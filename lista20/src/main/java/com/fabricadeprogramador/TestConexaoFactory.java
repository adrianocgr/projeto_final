package com.fabricadeprogramador;

import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class TestConexaoFactory {
	public static void main(String[] args){
		ConexaoFactory.getConnection();
		System.out.println("Conectou com sucesso");
	}
}
