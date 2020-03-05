package se.rezaul.PointOfSale;

public class ShowFood {
	private int id;
	private int item_quantity;
	private String item_name;

	private String item_category;
	private String item_image;
	private float item_price;
	private String table_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public float getItem_price() {
		return item_price;
	}
	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	@Override
	public String toString() {
		return "ShowFood [id=" + id + ", item_quantity=" + item_quantity + ", item_name=" + item_name
				+ ", item_category=" + item_category + ", item_image=" + item_image + ", item_price=" + item_price
				+ ", table_name=" + table_name + "]";
	}
}
