package com.lab1.apirest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lab1.apirest.servicos.DisciplinaServices;
import com.lab1.apirest.entidades.Disciplina;
import com.lab1.apirest.entidades.DisciplinaDTO;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaServices disciplinaServices;

	@GetMapping("/v1/api/disciplinas (id numerico, nome, nota)")
	public ResponseEntity <List<Disciplina>> getDisciplina() {
		return new ResponseEntity<List<Disciplina>>(disciplinaServices.getDisciplina(),HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getById(@PathVariable(value="id") Integer id) {
		try{
			return new ResponseEntity<Disciplina>(disciplinaServices.getById(id), HttpStatus.OK);
		}catch (IndexOutOfBoundsException iobe) {
			return new ResponseEntity<Disciplina>(new Disciplina (), HttpStatus.NOT_FOUND);			
		}	
	}
	
	@GetMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity <List<Disciplina>> getByRanking() {
		return new ResponseEntity<List<Disciplina>>(disciplinaServices.getByRanking(),HttpStatus.OK);
	}
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> addDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
		return new ResponseEntity<Disciplina>(disciplinaServices.addDisciplina(disciplinaDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> delete(@PathVariable(value="id") Integer id) {
		try{
			return new ResponseEntity<Disciplina>(disciplinaServices.delete(id), HttpStatus.OK);
		}catch (IndexOutOfBoundsException iobe) {
			return new  ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);		
		}
			
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> attDisciplinaNome(@PathVariable(value="id") Integer id, @RequestBody DisciplinaDTO disciplinaDTO) {
		try {
			return new ResponseEntity<Disciplina>(disciplinaServices.attDisciplina(id, disciplinaDTO), HttpStatus.OK);
		}catch(IndexOutOfBoundsException iobe) {
			return new  ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> attDisciplinaNota(@PathVariable(value="id") Integer id, @RequestBody DisciplinaDTO disciplinaDTO) {
		try {
			return new ResponseEntity<Disciplina>(disciplinaServices.attDisciplina(id, disciplinaDTO), HttpStatus.OK);
		}catch(IndexOutOfBoundsException iobe) {
			return new  ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}

	
	


}
	

