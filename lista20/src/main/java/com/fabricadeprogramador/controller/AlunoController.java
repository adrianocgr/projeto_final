package com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fabricadeprogramador.persistencia.dao.AlunoDAO;
import com.fabricadeprogramador.persistencia.entidade.Aluno;

@WebServlet("/aluno.do")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlunoController() {
		System.out.println("Chamando o construtor do servlet");
	}

	public void init() throws ServletException {
		System.out.println("Iniciando o servlet");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Requisiçao pelo metodo GET");
		String acao = request.getParameter("acao");
		String nome = request.getParameter("nome");
		String nota = request.getParameter("nota");
		
		AlunoDAO aluDao = new AlunoDAO();

		if (acao.equalsIgnoreCase("cad")) {
			// Criando objeto usuario e atribuindo valores da tela

			Aluno aluno = new Aluno();

			aluno.setNome(nome);
			aluno.setNota(Double.parseDouble(nota));

			// Criando um usuarioDAO
			AlunoDAO alunoDao = new AlunoDAO();

			// Salvando no banco de dados
			alunoDao.cadastrarNotaAluno(aluno);

			// Imprimindo resposta no navegador
			response.getWriter().print("salvo com sucesso");

		}else if(acao.equalsIgnoreCase("list")){

			// carrega lista dos usuarios
			List<Aluno> aluno = aluDao.buscaTodos();
								
			//
		
			// colocar a lista dentro da requisicao
			request.setAttribute("lista", aluno);

			//
			request.getRequestDispatcher("WEB-INF/listaluno.jsp").forward(
					request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Requisição pelo metodo POST");
				
		String nome = request.getParameter("nome");
		String nota = request.getParameter("nota");

		// Criando objeto usuario e atribuindo valores da tela

		Aluno aluno = new Aluno();

		aluno.setNome(nome);
		aluno.setNota(Double.parseDouble(nota));
	
		// Criando um alunoDAO
		AlunoDAO alunoDao = new AlunoDAO();

		// Salvando no banco de dados
		alunoDao.cadastrarNotaAluno(aluno);
		
		response.sendRedirect("aluno.do?acao=list");
		
		// Imprimindo resposta no navegador
		response.getWriter().print("salvo com sucesso");
	}
}
