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
public class TurmaDTO {


	private Long id;
	
	private String nome;
	
	private String ensinoNome;
	
	private int ano;
	
	private int quantidadeAlunos;
	
	
}
