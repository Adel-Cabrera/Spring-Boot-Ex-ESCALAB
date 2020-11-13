package com.example.app.escalab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.escalab.model.Paciente;
import com.example.app.escalab.repository.PacienteRepositoryInterface;
import com.example.app.escalab.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteRepositoryInterface pacienteRepositoryInterface;

	@Override
	public List<Paciente> getAll() {
		// TODO Auto-generated method stub
		return pacienteRepositoryInterface.findAll();
	}

	@Override
	public Paciente save(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteRepositoryInterface.save(paciente);
	}
	
}
