package se.rezaul.PointOfSale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteItem {
	Connection con = null;
	public DeleteItem() {
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
	
	public void deleteItem(String id) {
		String sql = "DELETE FROM Item WHERE id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,id);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
