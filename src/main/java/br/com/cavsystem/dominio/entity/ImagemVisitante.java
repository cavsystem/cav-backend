package br.com.cavsystem.dominio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import br.com.cavsystem.dominio.entity.dto.ImagemVisitanteDTO;

@Entity
public class ImagemVisitante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String base64;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Visitante visitante;
	
	public ImagemVisitante(ImagemVisitanteDTO dto) {
		super();
		this.id = dto.getId();
		this.base64 = dto.getBase64();
		this.visitante = dto.getVisitante() != null ? new Visitante(dto.getVisitante()):null;
	}

	public ImagemVisitante() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	
}
