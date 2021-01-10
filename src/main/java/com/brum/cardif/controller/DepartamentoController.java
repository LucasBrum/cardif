package com.brum.cardif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brum.cardif.entity.Cargo;
import com.brum.cardif.entity.Departamento;
import com.brum.cardif.model.Response;
import com.brum.cardif.respository.DepartamentoRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping
	public ResponseEntity<Response<List<Departamento>>> listar() {
		
		List<Departamento> departamentos = this.departamentoRepository.findAll();
		
		Response<List<Departamento>> response = new Response<>();
		response.setData(departamentos);
		response.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response , HttpStatus.OK);
	}
}
