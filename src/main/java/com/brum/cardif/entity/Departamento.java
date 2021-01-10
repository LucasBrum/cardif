package com.brum.cardif.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "departamento")
@NoArgsConstructor
public class Departamento implements Serializable{

	private static final long serialVersionUID = 9009748259450654448L;

	@Id
	@Column(name = "departamento_id")
	private Long id;
	
	@Column(name = "departamento_name")
	private String nome;
	
}
