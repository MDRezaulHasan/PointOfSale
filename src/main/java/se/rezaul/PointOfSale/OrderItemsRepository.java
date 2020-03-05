package se.rezaul.PointOfSale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsRepository {
	Connection con = null;
	public OrderItemsRepository()
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
	public List<OrderedItems> getOrderItems(int order_id){
		List<OrderedItems> items = new ArrayList<>();
		String sql = "select * from OrderedItems where order_id ="+order_id;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) 
			{
				OrderedItems a = new OrderedItems();
				a.setId(rs.getInt(1));
				a.setItem_quantity(rs.getInt(2));
				a.setItem_id(rs.getInt(3));
				a.setOrder_id(rs.getInt(4));
				items.add(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return items;
		
	}
	
	public void create(OrderedItems items) {
		String sql = "insert into OrderedItems values (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(2, items.getItem_quantity());
			st.setInt(3, items.getItem_id());
			st.setInt(4, items.getOrder_id());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}