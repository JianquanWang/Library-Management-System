package tech.oldwang.domain;

public class Book {
	private String id;
	private String name;
	private Category category;
	private float price;
	private String cover;
	private String remark;
	
	public Book() {
		
	}
	public Book(String id, String name, Category category, float price, String cover, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.cover = cover;
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", cover=" + cover
				+ ", remark=" + remark + "]";
	}
	
	
}
