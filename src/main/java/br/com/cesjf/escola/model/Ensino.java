package br.com.cesjf.escola.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ensino_tb")
public class Ensino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ensino_id")
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "ensino")
	private List<Turma> turmas;

}
