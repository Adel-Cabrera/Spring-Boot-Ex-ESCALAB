package com.example.tarea.escalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarea.escalab.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
