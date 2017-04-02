package com.org.food.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "food_ID", referencedColumnName = "id")
	private Food food;

	@Column(name = "pathimage")
	private String pathImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", food ID =" +getFood().getId() + ", pathImage=" + pathImage + "]";
	}

}
