package br.com.fabricadeprogramador.persistencia.entidade;

import java.util.List;

public class Cliente {
	private Long id;
	private String nome;
	private Cidade cidade;
	private List<Contato> contatos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	//metodo para adicionar um novo contato
	public void adicionarContato(Contato contato){
		Contato addContato = new Contato();
		TipoContato addTipoContato = new TipoContato();
		
		addTipoContato.setId(1);
		addTipoContato.setTipo("joao");
		
		addContato.setId((long) 1);
		addContato.setContato("adriano");
		addContato.setTipo(addTipoContato);
		
	}
	
	//metodo para remover um contato
	public void removerContato(Contato contato){
		
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		cliente.adicionarContato();
		
	}
	
}
