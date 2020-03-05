package se.rezaul.PointOfSale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
	Connection con = null;
	public OrderRepository()
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
	public List<Order> getOrders()
	{
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM restdb.order where status = 0";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) 
			{
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setTable_name(rs.getString("table_name"));
				orders.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return orders;
		
	}


}
