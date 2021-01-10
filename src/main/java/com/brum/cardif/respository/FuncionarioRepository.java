package com.brum.cardif.respository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brum.cardif.entity.Departamento;
import com.brum.cardif.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findAllByDepartamentosIn(Set<Departamento> departamentos);

}
