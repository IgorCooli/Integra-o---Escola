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

import br.com.cesjf.escola.dto.EnsinoDTO;
import br.com.cesjf.escola.model.Ensino;
import br.com.cesjf.escola.repository.EnsinoRepository;

@RestController
@RequestMapping("/ensino")
public class EnsinoResource {
	
	@Autowired
	EnsinoRepository repo;
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.encontrarPeloId(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody EnsinoDTO dto){
		
		Ensino model = new Ensino();
		
		if(dto.getId() != null) {
			model.setId(dto.getId());
		}
		
		model.setNome(dto.getNome());
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Tipo de ensino cadastrado com sucesso!!!");
		
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.encontrarTodos());
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		EnsinoDTO dto = new EnsinoDTO();
		dto = repo.encontrarPeloId(id);
		
		Ensino model = new Ensino();
		
		if(dto.getQuantidadeTurmas() == 0) {
			model.setId(id);
			model.setNome(dto.getNome());
			
			repo.delete(model);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Tipo de ensino removido com sucesso!!!");
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Não foi possível remover o tipo de ensino, pois existem turmas cadastradas!!!");
		}
		
		
	}

}
