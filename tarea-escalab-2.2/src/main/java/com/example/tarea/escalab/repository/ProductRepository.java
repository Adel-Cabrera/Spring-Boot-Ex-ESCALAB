package com.example.tarea.escalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarea.escalab.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
