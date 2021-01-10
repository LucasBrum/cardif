package com.brum.cardif.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDTO {

	@NotBlank(message = "Digite o nome do funcionário")
	private String nome;

	@NotNull(message = "Digite a idade do funcionário")
	private Integer idade;

	@NotBlank(message = "Digite o documento do funcionário")
	private String documento;

	@NotNull
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataNascimento;
	
	@NotNull
	private Long cargoId;
	
	private Long departamentoId;

}
