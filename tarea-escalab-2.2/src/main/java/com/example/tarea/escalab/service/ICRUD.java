package com.example.tarea.escalab.service;

import java.util.List;

public interface ICRUD <T>{
	
	T create(T obj);
	T update(T obj);
	List<T> getall();
	T getById(Integer id);
	boolean delete(Integer id);


}
