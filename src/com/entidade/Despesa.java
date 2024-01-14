package com.entidade;

public class Despesa {

	private String nome;
	private double valor;
	private int recorrencia;
	
	
	public Despesa(String nome, double valor, int recorrencia) {
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getRecorrencia() {
		return recorrencia;
	}
	public void setRecorrencia(int recorrencia) {
		this.recorrencia = recorrencia;
	}
	
	
	
	
}
