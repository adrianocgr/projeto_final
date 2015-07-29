package com.fabricadeprogramador.persistencia.jdbc;

/*
 * Lista de Exercício 20 - Fabrica de Programador - Turma 6
 * Aluno: Adriano da Silva Gomes
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabrica", "postgres", "123456");
			
		} catch (SQLException ex) {
			//Embrulhando a Exception SQLException em uma RuntimeException para a classe que chamar a conexao nao ficar dependente do JDBC
			throw new RuntimeException("Não conectou com o banco!", ex);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
