package com.example.app.escalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.escalab.model.Paciente;

@Repository
public interface PacienteRepositoryInterface extends JpaRepository<Paciente, Integer> {

}
