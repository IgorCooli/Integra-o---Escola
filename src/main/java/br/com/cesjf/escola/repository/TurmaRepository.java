package br.com.cesjf.escola.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cesjf.escola.dto.TurmaDTO;
import br.com.cesjf.escola.model.Turma;

@Repository
@Transactional
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	@Query("select new br.com.cesjf.escola.dto.TurmaDTO"
			+ "(t.id, t.nome, t.ensino.nome, t.ano, t.alunos.size) "
			+ "from Turma t "
			+ "where t.id = :id"
		)
    public TurmaDTO encontrarPeloId(@Param("id") Long id);
	
	@Query("select new br.com.cesjf.escola.dto.TurmaDTO"
			+ "(t.id, t.nome, t.ensino.nome, t.ano, t.alunos.size) "
			+ "from Turma t "
		)
    public List<TurmaDTO> encontrarTodos();

	Turma findByNome(String nome);

}
