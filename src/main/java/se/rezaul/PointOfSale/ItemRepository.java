package se.rezaul.PointOfSale;

import java.util.List;

import java.util.ArrayList;
import java.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class ItemRepository {
	Connection con = null;
	public ItemRepository()
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
	
	public List<Item> getItems()
	{
		List<Item> items = new ArrayList<>();
		String sql = "select * from Item";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) 
			{
				Item a = new Item();
				a.setId(rs.getInt(1));
				a.setItem_name(rs.getString("item_name"));
				if (rs.getString("item_category") == null) {
					a.setItem_category("1");
				}
				else {
					a.setItem_category(rs.getString("item_category"));
				}
				
				if (rs.getString("item_image") == null) {
					a.setItem_image("");
				}
				else {
					a.setItem_image(rs.getString("item_image"));
				}
				a.setItem_price(rs.getFloat("item_price"));
				items.add(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return items;
		
	}

	
	public void insertItems(String itemName, String price, String catagory, String myloc) throws FileNotFoundException {
	
	File largeFile = new File("/Users/muhammad.zafar/Downloads/" + myloc);
    String encodedString = encodeFileToBase64Binary(largeFile);
		
		String sql = "insert into Item (item_name,item_category,item_price,item_image) values (?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, itemName);
			st.setString(2, catagory);	
			st.setString(3, price);
			st.setString(4, encodedString);
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
	
	public boolean getOrdeSataus(String table_name) {
		List<Order> order = new ArrayList<>();
		String sql = "select * from restdb.order where table_name = '"+table_name+"' and status = 0";
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) 
			{
				Order a = new Order();
				a.setId(rs.getInt(1));
				a.setTable_name(rs.getString("table_name"));
				a.setStatus(rs.getInt("status"));
				order.add(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		if (order.size() == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            @SuppressWarnings("resource")
			FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
	
}
