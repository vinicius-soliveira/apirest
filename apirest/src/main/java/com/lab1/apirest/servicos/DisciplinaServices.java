package com.lab1.apirest.servicos;

import com.lab1.apirest.entidades.Disciplina;
import com.lab1.apirest.entidades.DisciplinaDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DisciplinaServices {

	private static List<Disciplina> listaDisciplinas = new ArrayList<>();
	
	static {
       listaDisciplinas.add(new Disciplina(1, "Introdução a Programação", 8.5));
       listaDisciplinas.add(new Disciplina(2, "Estrutura de Dados", 7.8));    
       listaDisciplinas.add(new Disciplina(3, "Programação Orientada a Objetos", 8.9)); 
    }
     
	public List<Disciplina> getDisciplina() {
        return new ArrayList<Disciplina>(listaDisciplinas);
    }
	
	public Disciplina getById(Integer id) {
        Disciplina disciplina = new Disciplina();
        for(int index = 0; index < listaDisciplinas.size(); index ++) {
        	if(id == listaDisciplinas.get(index).getId()) {
        		disciplina = listaDisciplinas.get(index);
        	}
        }
        return disciplina;
    }
      
	public List<Disciplina> getByRanking() {
		Collections.sort(listaDisciplinas, Disciplina.NotaComparator);
        return new ArrayList<Disciplina>(listaDisciplinas);
    }
    
	public Disciplina addDisciplina(DisciplinaDTO disciplina) {
		int newId = disciplina.geraId();
		String newNome = disciplina.getNome();
		double newNota = disciplina.getNota();
		Disciplina newDisciplina = new Disciplina(newId, newNome, newNota);
		listaDisciplinas.add(newDisciplina);
        return newDisciplina;
    }
	
	public Disciplina delete(Integer id) {
		Disciplina disciplina = new Disciplina();
        for(int index = 0; index < listaDisciplinas.size(); index ++) {
        	if(id == listaDisciplinas.get(index).getId()) {
        		disciplina = listaDisciplinas.remove(index);
        	}
        }
        return disciplina;
    }
	
	public Disciplina attDisciplina(Integer id, DisciplinaDTO disciplina) {
		Disciplina newDisciplina = getById(id);
		String newNome = disciplina.getNome();
		Double newNota = disciplina.getNota();
		if(newNome != null && (newNota <= 0.0 || newNota > 10.0) )
			newDisciplina.setNome(newNome);
		if(newNota >=0.0 && newNota <=10.0 && newNome == null)
			newDisciplina.setNota(newNota);
        return newDisciplina;
	}

	
}
