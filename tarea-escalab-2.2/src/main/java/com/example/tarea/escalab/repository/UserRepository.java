package com.example.tarea.escalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tarea.escalab.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
