package br.com.cesjf.escola.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cesjf.escola.dto.EnsinoDTO;
import br.com.cesjf.escola.model.Ensino;

@Repository
@Transactional
public interface EnsinoRepository extends JpaRepository<Ensino, Long>{
	
	@Query("select new br.com.cesjf.escola.dto.EnsinoDTO"
			+ "(e.id, e.nome, e.turmas.size) "
			+ "from Ensino e "
			+ "where e.id = :id"
		)
    public EnsinoDTO encontrarPeloId(@Param("id") Long id);
	
	@Query("select new br.com.cesjf.escola.dto.EnsinoDTO"
			+ "(e.id, e.nome, e.turmas.size) "
			+ "from Ensino e "
		)
    public List<EnsinoDTO> encontrarTodos();
	

	Ensino findByNome(String nome);

}
