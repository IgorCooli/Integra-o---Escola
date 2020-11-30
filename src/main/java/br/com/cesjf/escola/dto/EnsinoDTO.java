package br.com.cesjf.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EnsinoDTO {
	
	private Long id;
	
	private String nome;
	
	private int quantidadeTurmas;

}
