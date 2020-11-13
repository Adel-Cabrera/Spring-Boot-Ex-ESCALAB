package com.example.tarea.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea.escalab.model.Category;
import com.example.tarea.escalab.repository.CategoryRepository;
import com.example.tarea.escalab.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category create(Category obj) {
		return categoryRepository.save(obj);
	}

	@Override
	public Category update(Category obj) {
		return categoryRepository.save(obj);
	}

	@Override
	public List<Category> getall() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getById(Integer id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Category();
		}
	}

	@Override
	public boolean delete(Integer id) {
		categoryRepository.deleteById(id);
		return false;
	}

}
