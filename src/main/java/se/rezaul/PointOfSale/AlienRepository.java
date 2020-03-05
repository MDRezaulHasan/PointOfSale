package se.rezaul.PointOfSale;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class AlienRepository 
{
	Connection con = null;
	public AlienRepository()
	{
		String url = "jdbc:mysql://localhost:3306/restdb?useSSL=false";
		String username = "root";
		String password= "12345678";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}


	public boolean create(JSONObject a1) {
		
		Order order = this.getOrder(a1);
		
		String sql = "insert into restdb.order (table_name, status) VALUES (?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, order.getTable_name());
			st.setInt(2, order.getStatus());
			//st.executeUpdate();
			int affectedRows = st.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating order failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	               int id = order.setId(generatedKeys.getInt(1));
	               List<OrderedItems> items = this.getItems(a1);
	               System.out.println(id);
	               for(int i = 0; i < items.size(); i++)
		       		{
		       			OrderedItems item = items.get(i);
		       			
		       			String item_sql = "insert into restdb.OrderedItems (item_quantity, item_id, order_id) VALUES (?,?,?)";
		       			PreparedStatement item_st = con.prepareStatement(item_sql,Statement.RETURN_GENERATED_KEYS);
		       			item_st.setInt(1, item.getItem_quantity());
		       			item_st.setInt(2, item.getItem_id());
		       			item_st.setInt(3, id);
		       			item_st.executeUpdate();
		       		   
		       		}
	               return true;
	            }
	            else {
	                throw new SQLException("Creating orderitems failed, no ID obtained.");
	            }
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false;
		
	}
	
	private Order getOrder(JSONObject object) {
		Order order= new Order();
		order.setTable_name(object.getString("table_name"));
		order.setStatus(object.getInt("stauts"));
		return order;
	}
	private List<OrderedItems> getItems(JSONObject object) {
		List<OrderedItems> items = new ArrayList<>();
		JSONArray jArray = object.getJSONArray("orderItems");
		for(int i = 0; i < jArray .length(); i++)
		{
			OrderedItems item = new OrderedItems();
		   JSONObject object3 = jArray.getJSONObject(i);
		   item.setItem_id(object3.getInt("item_id"));
		   item.setItem_quantity(object3.getInt("quantity"));
		   items.add(item);
		}
		return items;
	}
	
}
