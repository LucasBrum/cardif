package com.brum.cardif.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDTO {

	private Integer id;
	
	@Size(min = 2, max = 3)
	@NotBlank(message = "Digite a idade do funcionário")
	private Integer idade;

	@NotBlank(message = "Digite o nome do funcionário")
	private String nome;
	
	@NotBlank(message = "Digite o documento do funcionário")
	private String documento;

	@NotBlank(message = "Digite o Data de Nascimento do funcionário")
	private Date dataNascimento;

}
