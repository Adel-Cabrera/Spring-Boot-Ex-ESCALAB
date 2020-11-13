package com.example.tarea.escalab.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProduct;
	
	@Column(name = "product_name", nullable = false, length = 70)
	private String productName;
	
	@Column(name = "description", nullable = false, length = 70)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_user_product"))
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "idProduct"), inverseJoinColumns = @JoinColumn(name = "id_category", referencedColumnName = "idCategory"))
	private List<Category> categories;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	

}
