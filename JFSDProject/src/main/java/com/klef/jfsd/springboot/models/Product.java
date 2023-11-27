package com.klef.jfsd.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_table")
public class Product 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	@Column(name = "product_name",nullable=false,length=50)
	private String name;
	@Column(name = "product_cost",nullable=false)
	private int cost;
	@Column(name = "product_type",nullable=false,length=50)
	private String type;
	
	@Column(name = "product_rating",nullable=true)
	private int rating;
	
	@Column(name = "product_description",nullable=false,length=200)
	private String description;
	

	@Column(name = "product_quantity",nullable=false)
	private int quantity;
	
	@Column(name = "producer_id",nullable=false)
	private int producerid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getRating() {
		return rating;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProducerid() {
		return producerid;
	}
	public void setProducerid(int producerid) {
		this.producerid = producerid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", type=" + type + ", rating=" + rating
				+ ", description=" + description + ", quantity=" + quantity + ", producerid=" + producerid + "]";
	}
	
	
	
}
