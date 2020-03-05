package se.rezaul.PointOfSale;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Item {
	private int id;
	private String item_name;
	private String item_category;
	private String item_image;
	private float item_price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", item_name=" + item_name + ", item_category=" + item_category + ", item_image=" + item_image +", item_price=" + item_price + "]";
	}
}
