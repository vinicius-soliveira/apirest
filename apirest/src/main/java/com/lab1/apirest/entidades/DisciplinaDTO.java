package com.lab1.apirest.entidades;

import java.util.Random;

public class DisciplinaDTO {
	
	private String nome;
	private double nota;
	
	public DisciplinaDTO(String nome, double nota) {
		this.nome = nome;
		this.nota = nota;
	}
	
	public DisciplinaDTO(double nota) {
		this.nota = nota;
	}
	
	public DisciplinaDTO(String nome) {
		this.nome = nome;
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
	
	public int geraId() {
		
		Random random = new Random();
		int id = random.nextInt(1000);
		return id;
		}
	
}
