package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.ImagemVisitante;

public class ImagemVisitanteDTO {
	
    private Long id;
	
	private String base64;
	
	private VisitanteDTO visitante;
	
	public ImagemVisitanteDTO(ImagemVisitante iv) {
		super();
		this.id = iv.getId();
		this.setBase64(iv.getBase64());
		this.visitante = iv.getVisitante() != null ? new VisitanteDTO(iv.getVisitante()) : null;
	}

	public ImagemVisitanteDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VisitanteDTO getVisitante() {
		return visitante;
	}

	public void setVisitante(VisitanteDTO visitante) {
		this.visitante = visitante;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

}
