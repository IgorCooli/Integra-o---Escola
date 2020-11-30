package br.com.cesjf.escola.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cesjf.escola.dto.AlunoDTO;
import br.com.cesjf.escola.model.Aluno;

@Repository
@Transactional
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	@Query("select new br.com.cesjf.escola.dto.AlunoDTO"
			+ "(a.id, a.nome, a.anoNascimento, a.turma.nome) "
			+ "from Aluno a "
			+ "where a.matricula = :id"
		)
    public AlunoDTO encontrarPeloId(@Param("id") Long id);
	
	@Query("select new br.com.cesjf.escola.dto.AlunoDTO"
			+ "(a.id, a.nome, a.anoNascimento, a.turma.nome) "
			+ "from Aluno a "
		)
    public List<AlunoDTO> encontrarTodos();
	
	public Aluno findByNome(String nome);

}
