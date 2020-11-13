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
import com.example.tarea.escalab.model.Product;
import com.example.tarea.escalab.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> listar() {
		List<Product> lista = productService.getall();
		return new ResponseEntity<List<Product>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Product p = productService.getById(id);
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}{
			return new ResponseEntity<Product>(new Product(), HttpStatus.NOT_FOUND);
		}
		/*
		if (pac.getIdProduct() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<Product> registrar(@Valid @RequestBody Product product) {
		Product p = productService.create(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Product> modificar(@Valid @RequestBody Product product) {
		Product p = productService.update(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Product p = productService.getById(id);
		if (p.getIdProduct() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		productService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}


}
