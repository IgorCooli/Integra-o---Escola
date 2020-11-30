package br.com.cesjf.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlunoDTO {
	
	private Long matricula;
	
	private String nome;
	
	private int anoNascimento;
	
	private String turmaNome;

}
