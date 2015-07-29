package com.fabricadeprogramador.persistencia.entidade;

/*
 * Lista de Exercício 20 - Fabrica de Programador - Turma 6
 * Aluno: Adriano da Silva Gomes
 * */

import java.sql.Date;

public class Venda {
	private Integer id;
	private double valor;
	private Date data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}	

}
