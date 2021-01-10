package com.brum.cardif.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brum.cardif.dto.FuncionarioDTO;
import com.brum.cardif.entity.Funcionario;
import com.brum.cardif.model.Response;
import com.brum.cardif.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<Response<Funcionario>> criar(@Valid @RequestBody FuncionarioDTO funcionarioDto) {
		
		Funcionario funcionario = this.funcionarioService.salvar(funcionarioDto);
		Response<Funcionario> response = new Response<>();
		response.setData(funcionario);
		response.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Funcionario>>> listar() {
		
		List<Funcionario> funcionarios = this.funcionarioService.listar();
		
		Response<List<Funcionario>> response = new Response<>();
		response.setData(funcionarios);
		response.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
