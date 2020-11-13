package com.example.tarea.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea.escalab.model.Product;
import com.example.tarea.escalab.repository.ProductRepository;
import com.example.tarea.escalab.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product create(Product obj) {
		return productRepository.save(obj);
	}

	@Override
	public Product update(Product obj) {
		return productRepository.save(obj);
	}

	@Override
	public List<Product> getall() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Product();
		}
	}

	@Override
	public boolean delete(Integer id) {
		productRepository.deleteById(id);
		return true;
	}

}
