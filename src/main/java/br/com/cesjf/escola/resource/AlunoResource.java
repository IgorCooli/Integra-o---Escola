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

import br.com.cesjf.escola.dto.AlunoDTO;
import br.com.cesjf.escola.model.Aluno;
import br.com.cesjf.escola.repository.AlunoRepository;
import br.com.cesjf.escola.repository.TurmaRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	@Autowired
	AlunoRepository repo;
	@Autowired
	TurmaRepository turmaRepo;
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		AlunoDTO dto = new AlunoDTO();
		
		dto = repo.encontrarPeloId(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAll(){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.encontrarTodos());
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody AlunoDTO dto){
		
		Aluno model = new Aluno();
		
		if(dto.getMatricula() != null) {
			model.setMatricula(dto.getMatricula());
		}
		
		model.setAnoNascimento(dto.getAnoNascimento());
		model.setMatricula(dto.getMatricula());
		model.setNome(dto.getNome());
		model.setTurma(turmaRepo.findByNome(dto.getTurmaNome()));
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Aluno cadastrado com sucesso!!!");
		
	}
	
	@DeleteMapping("/delete/{matricula}")
	public ResponseEntity<?> delete(@PathVariable Long matricula){
		
		AlunoDTO dto = new AlunoDTO();
		
		dto = repo.encontrarPeloId(matricula);
		
		Aluno model = new Aluno();
		
		model.setAnoNascimento(dto.getAnoNascimento());
		model.setMatricula(matricula);
		model.setNome(dto.getNome());
		model.setTurma(turmaRepo.findByNome(dto.getTurmaNome()));
		
		repo.delete(model);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aluno removido com sucesso!!!");
		
	}
	

}
