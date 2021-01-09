package com.brum.cardif.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CargoDTO {

	private Long id;

	@Size(min = 2, max = 30)
	@NotBlank(message = "Digite o nome do cargo")
	private String cargo;
}
