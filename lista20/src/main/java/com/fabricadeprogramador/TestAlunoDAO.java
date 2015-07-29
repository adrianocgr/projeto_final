package com.fabricadeprogramador;

import java.util.List;

import com.fabricadeprogramador.persistencia.dao.AlunoDAO;
import com.fabricadeprogramador.persistencia.entidade.Aluno;
import com.fabricadeprogramador.persistencia.entidade.Venda;


public class TestAlunoDAO {
	public static void main(String[] args) {
		//testCadastrar();
		testMedia();
	}
	
	private static void testCadastrar() {
		Aluno aluno = new Aluno();
		aluno.setNome("Adriano");
		aluno.setNota(10.0);
		
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.cadastrarNotaAluno(aluno);	
	}
	
	private static void testMedia(){
		AlunoDAO alunoDao = new AlunoDAO();
		System.out.println(alunoDao.media());
	}

}
