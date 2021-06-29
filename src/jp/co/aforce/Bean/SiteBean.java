package jp.co.aforce.Bean;

import java.io.Serializable;

public class SiteBean implements Serializable {

//m_user
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


//Bean
	
	public SiteBean() {

	}
	
//m_album
	
	private int num;
	
	private String album_name;
	
	private String day;
	
	private int price;
	
	private String image;
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
//m_cart
	
	private String cart_no;
	
	//private int num;
	
	//private String album_name;
	
	private int album_price;
	
	private int album_count;
	
	//private String username;
	
	private int total;

	public String getCart_no() {
		return cart_no;
	}

	public void setCart_no(String cart_no) {
		this.cart_no = cart_no;
	}

	public int getAlbum_price() {
		return album_price;
	}

	public void setAlbum_price(int album_price) {
		this.album_price = album_price;
	}

	public int getAlbum_count() {
		return album_count;
	}

	public void setAlbum_count(int album_count) {
		this.album_count = album_count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}	
	
	private int sub_total;

	public int getSub_total() {
		return sub_total;
	}

	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}
	
	
	
}
