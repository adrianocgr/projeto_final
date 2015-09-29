package br.com.fabricadeprogramador.persistencia.entidade;

public class Contato {
	private Long id;
	private TipoContato tipo;
	private String contato;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoContato getTipo() {
		return tipo;
	}
	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
}
