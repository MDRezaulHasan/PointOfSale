package se.rezaul.PointOfSale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowFoodRepository {

	Connection con = null;

	public ShowFoodRepository() {
		String url = "jdbc:mysql://localhost:3306/restdb?useSSL=false";
		String username = "root";
		String password = "12345678";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public List<ShowFood> getShowFood(String order_id) {
		List<ShowFood> showfoods = new ArrayList<>();
		

		
		
		String sql = "SELECT restdb.OrderedItems.id, restdb.OrderedItems.item_quantity,restdb.item.item_name,restdb.item.item_category,restdb.item.item_image,\n" + 
				"				restdb.item.item_price,restdb.order.table_name\n" + 
				"				FROM ((restdb.OrderedItems INNER JOIN restdb.item ON restdb.OrderedItems.item_id = restdb.item.id)\n" + 
				"				INNER JOIN restdb.order ON restdb.OrderedItems.order_id= restdb.order.id) where restdb.OrderedItems.order_id ="+order_id+"";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ShowFood showfood = new ShowFood();
				showfood.setId(rs.getInt(1));
				showfood.setItem_quantity(rs.getInt(2));
				showfood.setItem_name(rs.getString("item_name"));
				showfood.setItem_category(rs.getString("item_category"));
				showfood.setItem_image(rs.getString("item_image"));
				showfood.setItem_price(rs.getFloat("item_price"));
				showfood.setTable_name(rs.getString("table_name"));

				showfoods.add(showfood);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return showfoods;
	}

	public void orderStatus(String id) {
		System.out.println(id);
		// Order orderstatusUpdate = new Order();
		String sql = "UPDATE restdb.order\r\n" + "SET restdb.order.status = 1\r\n" + "WHERE restdb.order.id =?";
		try {

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,id);

			st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
//	public void deleteItem(String id) {
//		String sql = "DELETE FROM Item WHERE id=?";
//		try {
//			PreparedStatement st = con.prepareStatement(sql);
//			
//			st.setString(1,id);
//			
//			st.executeUpdate();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
//		
//	}

}