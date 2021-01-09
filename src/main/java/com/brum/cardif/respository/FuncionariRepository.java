package com.brum.cardif.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brum.cardif.entity.Funcionario;

@Repository
public interface FuncionariRepository extends JpaRepository<Funcionario, Integer> {

}
