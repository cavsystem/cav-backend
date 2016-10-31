package br.com.cavsystem.dominio.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.cavsystem.dominio.entity.dto.ApartamentoDTO;

@Entity
public class Apartamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String bloco;
	
	private String telefone;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Condominio condominio;

	
	public Apartamento(ApartamentoDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.bloco = dto.getBloco();
		this.telefone = dto.getTelefone();
		this.condominio = dto.getCondominio() != null ? new Condominio(dto.getCondominio()) : null;
	}

	public Apartamento() {
		super();
	}

	public String getConcat(){
		return getBloco()+" - "+getNome();
	}
	
	
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

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
