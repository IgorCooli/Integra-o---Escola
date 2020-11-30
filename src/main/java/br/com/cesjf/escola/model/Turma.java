package br.com.cesjf.escola.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "turma_tb")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "turma_id")
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "ensino_id")
	private Ensino ensino;
	
	private int ano;
		
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos;

}
