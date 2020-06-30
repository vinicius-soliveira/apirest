package com.lab1.apirest.entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Disciplina{
	
	private int id;
	private String nome;
	private double nota;
	
	public Disciplina(int id, String nome, double nota) {
		
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}
	public Disciplina() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	private static List<Disciplina> listaDisciplinas = new ArrayList<>();
	
	public int geraIdUnico(List<Disciplina> listaDisciplinas) {
		boolean idUnico = false;
		int id;
		Random random = new Random();
		
		do {
		    id = random.nextInt(1000);
			for(int index = 0; index < listaDisciplinas.size(); index ++) {
				if(id != listaDisciplinas.get(index).getId()) {
					continue;
				}
				
			}
			idUnico = true;
			break;
		}while(!idUnico);
		return id;
		}

	
	public static Comparator<Disciplina> NotaComparator = new Comparator<Disciplina>() {

		public int compare(Disciplina discp1, Disciplina discp2) {
		  double nota1 = discp1.getNota();
		  double nota2 = discp2.getNota(); 
		  
		   return Double.compare(nota2, nota1);
	    }};

	    public static Comparator<Disciplina> IdComparator = new Comparator<Disciplina>() {

			public int compare(Disciplina discp1, Disciplina discp2) {
			  int id1 = discp1.getId();
			  int id2 = discp2.getId(); 
			  
			   return (id1 - id2);
		    }};
	

}
