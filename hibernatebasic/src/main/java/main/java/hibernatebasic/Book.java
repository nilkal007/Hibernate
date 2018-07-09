package main.java.hibernatebasic;

public class Book {
	int bk_id;
	String bk_nm;
	long price;

	public Book() {
		super();
	}

	public Book(int bk_id, String bk_nm, long price) {
		super();
		this.bk_id = bk_id;
		this.bk_nm = bk_nm;
		this.price = price;
	}

	public int getBk_id() {
		return bk_id;
	}

	public void setBk_id(int bk_id) {
		this.bk_id = bk_id;
	}

	public String getBk_nm() {
		return bk_nm;
	}

	public void setBk_nm(String bk_nm) {
		this.bk_nm = bk_nm;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bk_id=" + bk_id + ", bk_nm=" + bk_nm + ", price=" + price + "]";
	}

}
