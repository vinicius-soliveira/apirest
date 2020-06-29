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
        disciplina = listaDisciplinas.get(id-1);
        return disciplina;
    }
      
	public List<Disciplina> getByRanking() {
		Collections.sort(listaDisciplinas, Disciplina.NotaComparator);
        return new ArrayList<Disciplina>(listaDisciplinas);
    }
    
	public Disciplina addDisciplina(DisciplinaDTO disciplina) {
		int newId = listaDisciplinas.size() +1;
		String newNome = disciplina.getNome();
		double newNota = disciplina.getNota();
		Disciplina newDisciplina = new Disciplina(newId, newNome, newNota);
		listaDisciplinas.add(newDisciplina);
        return newDisciplina;
    }
	
	public Disciplina delete(Integer id) {
        Disciplina disciplina = new Disciplina();
        disciplina = listaDisciplinas.remove(id-1);
        return disciplina;
    }
	
	public Disciplina attDisciplinaNome(Integer id, DisciplinaDTO disciplina) {
		Disciplina newDisciplina = getById(id);
		String newNome = disciplina.getNome();
		newDisciplina.setNome(newNome);
        return newDisciplina;
	}

	public Disciplina attDisciplinaNota(Integer id, DisciplinaDTO disciplina) {
		Disciplina newDisciplina= getById(id);
		double newNota = disciplina.getNota();
		newDisciplina.setNota(newNota);
        return newDisciplina;
	}
	
}
