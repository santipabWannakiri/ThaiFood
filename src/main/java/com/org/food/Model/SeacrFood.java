package com.org.food.Model;

import java.util.List;

public class SeacrFood {
	
	private Integer id;
	private String name;
	private String detail;
	private Double price;
	private Double discount;
	private String image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "SeacrFood [id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", discount="
				+ discount + ", image=" + image + "]";
	}
	

	
	

}
