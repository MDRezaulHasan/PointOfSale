package se.rezaul.PointOfSale;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private int id;
	private String table_name;
	private int status;
	
	private List<OrderedItems> orderItems;
	


	public int getId() {
		return id;
	}





	public int setId(int id) {
		return this.id = id;
	}





	public String getTable_name() {
		return table_name;
	}





	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}





	public int getStatus() {
		return status;
	}





	public void setStatus(int status) {
		this.status = status;
	}





	@Override
	public String toString() {
		return "Alien [id=" + id + ", table_name=" + table_name + ", status=" + status + "]";
	}





	public List<OrderedItems> getOrderItems() {
		return orderItems;
	}





	public void setOrderItems(List<OrderedItems> orderItems) {
		this.orderItems = orderItems;
	}
	
}
