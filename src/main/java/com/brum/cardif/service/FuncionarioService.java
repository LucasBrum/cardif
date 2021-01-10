package com.brum.cardif.service;

import java.util.List;

import com.brum.cardif.dto.FuncionarioDTO;
import com.brum.cardif.entity.Funcionario;

public interface FuncionarioService {

	Funcionario salvar(FuncionarioDTO funcionarioDto);

	Funcionario atualizar(Long id, FuncionarioDTO funcionarioDto);
	
	Funcionario buscaPeloId(Long id);
	
	List<Funcionario> listar();
	
	void delete(Long id);

	List<Funcionario> buscaPeloDepartamentoId(Long departamentoId);
	
	
}
