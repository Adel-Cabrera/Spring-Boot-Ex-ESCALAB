package com.example.app.escalab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.escalab.model.Paciente;
import com.example.app.escalab.service.PacienteService;

@RestController
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/paciente")
	@ResponseBody
	public List<Paciente> getAll(){
		return pacienteService.getAll();
	}
	
	@PostMapping("/paciente")
	@ResponseBody
	public Paciente save(@RequestBody Paciente paciente){
		return pacienteService.save(paciente);
	}
	
}
