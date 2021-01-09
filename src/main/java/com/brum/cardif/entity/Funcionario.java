package com.brum.cardif.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Integer id;
	
	@Column(name = "funcionario_age")
	private Integer idade;
	
	@Column(name = "funcionario_name")
	private String nome;
	
	@Column(name = "funcionario_document")
	private String documento;

	@Column(name = "funcionario_birthday")
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Cargo cargo;
}
