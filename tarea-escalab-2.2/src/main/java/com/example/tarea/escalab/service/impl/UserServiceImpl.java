package com.example.tarea.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea.escalab.model.User;
import com.example.tarea.escalab.repository.UserRepository;
import com.example.tarea.escalab.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User create(User obj) {
		return userRepository.save(obj);
	}

	@Override
	public User update(User obj) {
		return userRepository.save(obj);
	}

	@Override
	public List<User> getall() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Integer id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new User();
		}
	}

	@Override
	public boolean delete(Integer id) {
		userRepository.deleteById(id);
		return true;
	}

}
