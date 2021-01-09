package com.brum.cardif.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brum.cardif.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
