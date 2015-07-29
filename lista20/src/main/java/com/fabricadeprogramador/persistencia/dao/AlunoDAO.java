package com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fabricadeprogramador.persistencia.entidade.Aluno;
import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;


public class AlunoDAO {
	private Connection con = ConexaoFactory.getConnection();
	
	
	public void cadastrarNotaAluno(Aluno aluno){
		String sql = "INSERT INTO aluno (nome, nota) VALUES (?, ?)";
		
		try (PreparedStatement preparador =  con.prepareStatement(sql)) {
			preparador.setString(1, aluno.getNome());
			preparador.setDouble(2, aluno.getNota());
			
			preparador.execute();
			
			System.out.println("Cadastrou com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Aluno> buscaTodos(){
		List<Aluno> listaRetorno = new ArrayList<Aluno>();
		String sql = "SELECT * FROM aluno ORDER BY id";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				Aluno aluno = new Aluno();
				
				aluno.setId(resultado.getInt("id"));
				aluno.setNome(resultado.getString("nome"));
				aluno.setNota(resultado.getDouble("nota"));
								
				listaRetorno.add(aluno);
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public Double media(){
		AlunoDAO alunoDao = new AlunoDAO();
	    double somaNota = 0;
		double mediaNota;
		int cont = 0;
		
		List<Aluno> lista = alunoDao.buscaTodos();
		
		for(Aluno al : lista){
			somaNota = somaNota + al.getNota();
			cont++;
		}
		
		mediaNota = (double) somaNota/cont;
		
		return mediaNota;
	}
	

}
