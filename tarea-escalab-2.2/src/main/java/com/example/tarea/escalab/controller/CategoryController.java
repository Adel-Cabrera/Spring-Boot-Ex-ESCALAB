package com.example.tarea.escalab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarea.escalab.exception.ModeloNotFoundException;
import com.example.tarea.escalab.model.Category;
import com.example.tarea.escalab.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> listar() {
		List<Category> lista = categoryService.getall();
		return new ResponseEntity<List<Category>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Category c = categoryService.getById(id);
			return new ResponseEntity<Category>(c, HttpStatus.OK);
		}{
			return new ResponseEntity<Category>(new Category(), HttpStatus.NOT_FOUND);
		}
		/*
		if (pac.getIdProduct() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<Category> registrar(@Valid @RequestBody Category product) {
		Category c = categoryService.create(product);
		return new ResponseEntity<Category>(c, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Category> modificar(@Valid @RequestBody Category product) {
		Category c = categoryService.update(product);
		return new ResponseEntity<Category>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Category c = categoryService.getById(id);
		if (c.getIdCategory() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		categoryService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}


}
