package br.com.cavsystem.dominio.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.cavsystem.dominio.entity.dto.ImagemVisitanteDTO;
import br.com.cavsystem.dominio.entity.dto.VisitanteDTO;

@Entity
public class Visitante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String fone;
	
	private String celular;
	
	public Visitante(VisitanteDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.fone = dto.getFone();
		this.celular = dto.getCelular();
	}

	public Visitante() {
		super();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
		
	public List<ImagemVisitante> convertToList(List<ImagemVisitanteDTO> lista){
		List<ImagemVisitante> dtos = new ArrayList<>();
		if(!lista.isEmpty()){
			for (ImagemVisitanteDTO v : lista) {
				ImagemVisitante dto = new ImagemVisitante(v);
				dtos.add(dto);
			}
		}
		return dtos;
	}
}
