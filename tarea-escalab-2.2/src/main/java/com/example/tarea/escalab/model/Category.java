package com.example.tarea.escalab.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCategory;

	@Column(name = "category_name", nullable = false, length = 70)
	private String categoryName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "id_category", referencedColumnName = "idCategory"), inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "idProduct"))
	private List<Product> products;

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
