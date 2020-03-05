package se.rezaul.PointOfSale;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class insertItem {
	Connection con = null;
	FileInputStream fileInputStream=null;

	public insertItem()
	{
		String url = "jdbc:mysql://localhost:3306/posdb";
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
	
	
	public void insertItems(String id,String itemName, String price, String catagory, String myloc) {
		File image= new File(myloc);
	System.out.println(image);
		String sql = "insert into itemtb (id,itemName,price,catagory,image) values (?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, itemName);
			st.setString(3, price);
			st.setString(4, catagory);			
			fileInputStream=new FileInputStream(image);
			st.setBinaryStream(5, (InputStream) fileInputStream, (int) (image.length()));
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
}
