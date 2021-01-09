package com.brum.cardif.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.brum.cardif.entity.Cargo;
import com.brum.cardif.exception.CargoException;
import com.brum.cardif.respository.CargoRepository;
import com.brum.cardif.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	public List<Cargo> listarCargos() {
		try {
			return this.cargoRepository.findAll();
		} catch (Exception e) {
			throw new CargoException("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
