package br.com.cesjf.escola.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.escola.dto.TurmaDTO;
import br.com.cesjf.escola.model.Turma;
import br.com.cesjf.escola.repository.EnsinoRepository;
import br.com.cesjf.escola.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaResource {
	
	@Autowired
	TurmaRepository repo;
	@Autowired
	EnsinoRepository EnsinoRepo;
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.encontrarPeloId(id));
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.encontrarTodos());
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody TurmaDTO dto){
		
		Turma model = new Turma();
		
		if(dto.getId() != null) {
			model.setId(dto.getId());
		}
		
		model.setAno(dto.getAno());
		model.setEnsino(EnsinoRepo.findByNome(dto.getEnsinoNome()));
		model.setNome(dto.getNome());
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Turma cadastrada com sucesso!!!");
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		TurmaDTO dto = new TurmaDTO();
		dto = repo.encontrarPeloId(id);
		
		if(dto.getQuantidadeAlunos() == 0) {

			Turma model = new Turma();
			model.setAno(dto.getAno());
			model.setEnsino(EnsinoRepo.findByNome(dto.getEnsinoNome()));
			model.setId(id);
			model.setNome(dto.getNome());
			
			repo.delete(model);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Turma removida com sucesso!!!");
			
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Não foi possível remover a turma, pois existem alunos cadastrados!!!");
		}
		
	}

}
