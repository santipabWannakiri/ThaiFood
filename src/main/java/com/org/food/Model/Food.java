package com.org.food.Model;

import java.nio.file.Path;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Food")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@NotEmpty(message = "Please Enter You name")
	private String name;

	@Column(name = "detail")
	@NotEmpty(message = "Please Enter Detail!!")
	private String detail;

	@Column(name = "price")
	private Double price;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "promotionCode")
	private String promotionCode;

	@Column(name = "image")
	private String image;

	// name="createBy" << show to name column in database
	@ManyToOne
	@JoinColumn(name = "createBy", referencedColumnName = "user_id")
	private User referUser;

	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name="lastUpdate")
	private Date lastUpdate;

	@Column(name = "active")
	private Boolean active;

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

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getReferUser() {
		return referUser;
	}

	public void setReferUser(User referUser) {
		this.referUser = referUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", discount="
				+ discount + ", promotionCode=" + promotionCode + ", image=" + image + ", referUser=" + referUser
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + ", active=" + active + "]";
	}

	

	
	
}

