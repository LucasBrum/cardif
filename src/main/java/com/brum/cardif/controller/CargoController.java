package com.brum.cardif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brum.cardif.entity.Cargo;
import com.brum.cardif.model.Response;
import com.brum.cardif.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@GetMapping
	public ResponseEntity<Response<List<Cargo>>> listar() {
		
		List<Cargo> cargos = this.cargoService.listarCargos();
		
		Response<List<Cargo>> response = new Response<>();
		response.setData(cargos);
		response.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response , HttpStatus.OK);
	}
}
