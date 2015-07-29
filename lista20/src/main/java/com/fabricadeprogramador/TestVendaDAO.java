package com.fabricadeprogramador;

/*
 * Lista de Exercício 20 - Fabrica de Programador - Turma 6
 * Aluno: Adriano da Silva Gomes
 * */

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import com.fabricadeprogramador.persistencia.dao.VendaDAO;
import com.fabricadeprogramador.persistencia.entidade.Venda;

public class TestVendaDAO {
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		int op;

		do {
			System.out.println("1 - Buscar todas as venda");
			System.out.println("2 - Somar todas as venda");
			System.out.println("3 - Buscar vendas de determinada data");
			System.out.println("4 - Buscar vendas de determinado periodo");
			System.out.println("5 - Cadastrar uma venda");
			System.out.println("0 - Encerrar o sistema");
	
			op=leitor.nextInt();
			
			switch (op) {

			case 1:
				testBuscarTodasVendas();
				break;
			case 2:
				testSomaVendas();
				break;
			case 3:
				
				System.out.println("Digite a data no formato dd/MM/yyyy: ");
				String dt = leitor.next();

				Date dataVenda = null;
				
				try {

					dataVenda = new Date(df.parse(dt).getTime());

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				testBuscarVendas(dataVenda);

				break;
			case 4:
				System.out.println("Digite a data no formato dd/MM/yyyy: ");
				String dataInicial = leitor.next();

				System.out.println("Digite a data no formato dd/MM/yyyy: ");
				String dataFinal = leitor.next();

				Date dInicial = null;
				Date dFinal = null;

				try {

					dInicial = new Date(df.parse(dataInicial).getTime());
					dFinal = new Date(df.parse(dataFinal).getTime());

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				testBuscarVendasPeriodo(dInicial, dFinal);
				break;
			case 5:
				System.out.println("Digite o valor da venda: ");
				double valorVenda = leitor.nextDouble();
				System.out.println("Digite a data da venda no formato dd/MM/yyyy: ");
				String data_Venda = leitor.next();

				Date data = null;
				
				try {

					data = new Date(df.parse(data_Venda).getTime());
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				testCadastrar(valorVenda, data);
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		} while (op != 0);
		leitor.close();
	}

	// Metodo buscar todos

	private static void testBuscarTodasVendas() {
		VendaDAO vendDAO = new VendaDAO();

		List<Venda> lista = vendDAO.buscaTodos();
		for (Venda v : lista) {
			System.out.println(v.getId() + " " + v.getValor() + " "
					+ v.getData());
		}
	}

	// Metodo somar vendas

	private static void testSomaVendas() {
		VendaDAO vendDAO = new VendaDAO();
		double soma = 0;

		List<Venda> lista = vendDAO.buscaTodos();
		for (Venda v : lista) {
			soma += v.getValor();
		}
		System.out.println("Soma de todas as vendas: " + soma);
	}

	// Metodo buscar periodo

	private static void testBuscarVendasPeriodo(Date di, Date df) {
		VendaDAO vendDAO = new VendaDAO();

		List<Venda> lista = vendDAO.buscaPeriodo(di, df);
		for (Venda v : lista) {
			System.out.println(v.getId() + " " + v.getValor() + " "
					+ v.getData());
		}
	}
	
	//Metodo buscar uma data especifica
	
	private static void testBuscarVendas(Date dt) {
		VendaDAO vendDAO = new VendaDAO();

		List<Venda> lista = vendDAO.buscarVendas(dt);
		for (Venda v : lista) {
			System.out.println(v.getId() + " " + v.getValor() + " "
					+ v.getData());
		}
	}
	
	//Método cadastrar
	
	private static void testCadastrar(double valorVenda, Date dataVenda) {
		Venda venda = new Venda();
		venda.setValor(valorVenda);
		venda.setData(dataVenda);

		VendaDAO vendaDao = new VendaDAO();
		vendaDao.cadastrar(venda);
	}


}
