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
import com.example.tarea.escalab.model.User;
import com.example.tarea.escalab.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> listar() {
		List<User> lista = userService.getall();
		return new ResponseEntity<List<User>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			User u = userService.getById(id);
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}{
			return new ResponseEntity<User>(new User(), HttpStatus.NOT_FOUND);
		}
		/*
		if (pac.getIdUser() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<User> registrar(@Valid @RequestBody User user) {
		User u = userService.create(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> modificar(@Valid @RequestBody User user) {
		User u = userService.update(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		User u = userService.getById(id);
		if (u.getIdUser() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		userService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}


}
