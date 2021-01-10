package com.brum.cardif.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "funcionario_id")
	@GeneratedValue(generator = "increment")
	private Long id;
	
	@Column(name = "funcionario_age")
	private Integer idade;
	
	@Column(name = "funcionario_name")
	private String nome;
	
	@Column(name = "funcionario_document")
	private String documento;

	@Column(name = "funcionario_birthday")
	private LocalDate dataNascimento;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_departamento", 
			joinColumns = {@JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")},
			inverseJoinColumns = { @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id") })
	private Set<Departamento> departamentos = new HashSet<>();
	
	
}
