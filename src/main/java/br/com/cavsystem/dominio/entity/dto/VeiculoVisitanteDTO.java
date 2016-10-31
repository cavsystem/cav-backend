package br.com.cavsystem.dominio.entity.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

public class VeiculoVisitanteDTO {

	private Long id;
	
	private String placa;
	
	private String modelo;
	
	private String cor;
	
	private AtivoInativoEnum ativo;
	
	private VisitanteDTO visitante;
		
	public VeiculoVisitanteDTO (VeiculoVisitante veiculo) {
		super();
		this.id = veiculo.getId();
		this.placa = veiculo.getPlaca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.ativo = veiculo.getAtivo();
		this.visitante = veiculo.getVisitante() != null ? new VisitanteDTO(veiculo.getVisitante()) : null;
	}

	public VeiculoVisitanteDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public List<VeiculoVisitanteDTO> convertToList(List<VeiculoVisitante> list){
		List<VeiculoVisitanteDTO> dtos = new ArrayList<>();
		if(!list.isEmpty()){
			for (VeiculoVisitante v : list) {
				VeiculoVisitanteDTO dto = new VeiculoVisitanteDTO(v);
				dtos.add(dto);
			}
		}
		return dtos;
	}

	public VisitanteDTO getVisitante() {
		return visitante;
	}

	public void setVisitante(VisitanteDTO visitante) {
		this.visitante = visitante;
	}

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}

}
