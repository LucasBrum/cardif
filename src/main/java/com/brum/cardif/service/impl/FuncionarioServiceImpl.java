package com.brum.cardif.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.brum.cardif.dto.FuncionarioDTO;
import com.brum.cardif.entity.Departamento;
import com.brum.cardif.entity.Funcionario;
import com.brum.cardif.exception.FuncionarioException;
import com.brum.cardif.respository.DepartamentoRepository;
import com.brum.cardif.respository.FuncionarioRepository;
import com.brum.cardif.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private ModelMapper mapper;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		this.mapper = new ModelMapper();
		this.mapper.getConfiguration().setAmbiguityIgnored(true);
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	public Funcionario salvar(FuncionarioDTO funcionarioDto) {
		try {
			Optional<Departamento> departamento = this.departamentoRepository
					.findById(funcionarioDto.getDepartamentoId());
			Funcionario funcionario = this.mapper.map(funcionarioDto, Funcionario.class);

			if (departamento.isPresent()) {
				funcionario.getDepartamentos().add(departamento.get());
			}

			return this.funcionarioRepository.save(funcionario);
		} catch (Exception e) {
			throw new FuncionarioException("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Funcionario atualizar(Long id, FuncionarioDTO funcionarioDto) {
		try {
			this.buscaPeloId(id);

			Funcionario funcionarioAtualizado = this.mapper.map(funcionarioDto, Funcionario.class);
			funcionarioAtualizado.setId(id);

			return this.funcionarioRepository.save(funcionarioAtualizado);
		} catch (FuncionarioException funcionarioException) {
			throw funcionarioException;
		} catch (Exception e) {
			throw new FuncionarioException("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Funcionario> listar() {
		try {
			return this.funcionarioRepository.findAll();
		} catch (Exception e) {
			throw new FuncionarioException("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			this.buscaPeloId(id);
			this.funcionarioRepository.deleteById(id);

		} catch (FuncionarioException funcionarioException) {
			throw funcionarioException;
		} catch (Exception e) {
			throw new FuncionarioException("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public Funcionario buscaPeloId(Long id) {
		try {
			Optional<Funcionario> funcionarioOptional = this.funcionarioRepository.findById(id);

			if (funcionarioOptional.isPresent()) {
				return funcionarioOptional.get();
			}
			throw new FuncionarioException("Funcionário não encontrado.", HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			throw new FuncionarioException("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Funcionario> buscaPeloDepartamentoId(Long departamentoId) {
		Set<Departamento> departamentoSet = new HashSet<>();
		Optional<Departamento> departamento = this.departamentoRepository.findById(departamentoId);
		
		if (departamento.isPresent()) {
			departamentoSet.add(departamento.get());
		}
		
		List<Funcionario> funcionarios = this.funcionarioRepository.findAllByDepartamentosIn(departamentoSet);
		
		return funcionarios;
	}
}
