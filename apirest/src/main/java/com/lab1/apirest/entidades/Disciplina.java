package com.lab1.apirest.entidades;

import java.util.Comparator;

public class Disciplina {
	
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

	public static Comparator<Disciplina> NotaComparator = new Comparator<Disciplina>() {

		public int compare(Disciplina disp1, Disciplina disp2) {
		  double nota1 = disp1.getNota();
		  double nota2 = disp2.getNota(); 
		  
		   return Double.compare(nota2, nota1);
	    }};

	
	

}
