package fatec.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends EntidadeDominio {

	private String nome;
	@ManyToOne
	private Estado estado;
	
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
	
}
