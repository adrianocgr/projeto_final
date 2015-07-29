package com.fabricadeprogramador.persistencia.dao;

/*
 * Lista de Exercício 20 - Fabrica de Programador - Turma 6
 * Aluno: Adriano da Silva Gomes
 * */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.fabricadeprogramador.persistencia.entidade.Venda;
import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;


public class VendaDAO {
	
	private Connection con = ConexaoFactory.getConnection();
	
	//Metodo criado para buscar todas a vendas no banco de dados
	public List<Venda> buscaTodos(){
		List<Venda> listaRetorno = new ArrayList<Venda>();
		String sql = "SELECT * FROM vendas ORDER BY id";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				Venda venda = new Venda();
				
				venda.setId(resultado.getInt("id"));
				venda.setValor(resultado.getDouble("valor"));
				venda.setData(resultado.getDate("data_venda"));
								
				listaRetorno.add(venda);
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listaRetorno;
	}	
	
	//Metodo criado para buscar as vendas de deternubado período no banco
	public List<Venda> buscaPeriodo(Date di, Date df){
		List<Venda> listaRetorno = new ArrayList<Venda>();
		String sql = "select * from vendas where data_venda >= ? and data_venda <= ? order by id";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setDate(1, di);
			preparador.setDate(2, df);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				Venda venda = new Venda();
				
				venda.setId(resultado.getInt("id"));
				venda.setValor(resultado.getDouble("valor"));
				venda.setData(resultado.getDate("data_venda"));
								
				listaRetorno.add(venda);
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listaRetorno;
	}	
	
	//Função criada para buscar a venda de determinado dia
	public List<Venda> buscarVendas(Date dt){
		List<Venda> listaRetorno = new ArrayList<Venda>();
		String sql = "select * from vendas where data_venda = ? order by id";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setDate(1, dt);
						
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				Venda venda = new Venda();
				
				venda.setId(resultado.getInt("id"));
				venda.setValor(resultado.getDouble("valor"));
				venda.setData(resultado.getDate("data_venda"));
								
				listaRetorno.add(venda);
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	//Função criada para cadastrar novas vendas
	public void cadastrar(Venda venda) {
		String sql = "INSERT INTO vendas (valor, data_venda) VALUES (?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setDouble(1, venda.getValor());
			preparador.setDate(2,venda.getData());
			
			preparador.execute();
			
			System.out.println("Cadastrou com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
