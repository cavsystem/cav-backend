package br.com.cavsystem.dominio.entity.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.cavsystem.dominio.entity.ImagemVisitante;
import br.com.cavsystem.dominio.entity.Visitante;

public class VisitanteDTO {

	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String fone;
	
	private String celular;
		
	public VisitanteDTO() {
		super();
	}

	public VisitanteDTO(Visitante visitante) {
		super();
		this.id = visitante.getId();
		this.nome = visitante.getNome();
		this.cpf = visitante.getCpf();
		this.fone = visitante.getFone();
		this.celular = visitante.getCelular();
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

	public List<ImagemVisitanteDTO> convertToList(List<ImagemVisitante> lista){
		List<ImagemVisitanteDTO> dtos = new ArrayList<>();
		if(!lista.isEmpty()){
			for (ImagemVisitante v : lista) {
				ImagemVisitanteDTO dto = new ImagemVisitanteDTO(v);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	
}
