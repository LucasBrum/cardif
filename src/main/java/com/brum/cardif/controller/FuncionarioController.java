package com.brum.cardif.controller;

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
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Funcionario>>> listar() {
		
		List<Funcionario> funcionarios = this.funcionarioService.listar();
		
		Response<List<Funcionario>> response = new Response<>();
		response.setData(funcionarios);
		response.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<Funcionario>> atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
		Funcionario funcionarioAtualizado = this.funcionarioService.atualizar(id, funcionarioDTO);
		
		Response<Funcionario> response = new Response<>();
		response.setStatus(HttpStatus.OK.value());
		response.setData(funcionarioAtualizado);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		this.funcionarioService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/departamento/{departamentoId}")
	public ResponseEntity<Response<List<Funcionario>>> buscaPeloDepartamentoId(@PathVariable Long departamentoId) {
		
		List<Funcionario> funcionarios = this.funcionarioService.buscaPeloDepartamentoId(departamentoId);
		
		Response<List<Funcionario>> response = new Response<>();
		response.setStatus(HttpStatus.OK.value());
		response.setData(funcionarios);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
