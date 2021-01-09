package com.brum.cardif.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cargo implements Serializable {

	private static final long serialVersionUID = -6445126220862825986L;

	@Id
	@Column(name = "cargo_id")
	@JsonInclude(Include.NON_NULL)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "cargo_name")
	private String nome;
}
