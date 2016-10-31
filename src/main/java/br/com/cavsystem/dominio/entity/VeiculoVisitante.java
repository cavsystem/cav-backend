package br.com.cavsystem.dominio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.cavsystem.dominio.entity.dto.VeiculoVisitanteDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

@Entity
public class VeiculoVisitante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String placa;
	
	private String modelo;
	
	private String cor;
	
	@Enumerated(EnumType.STRING)
	private AtivoInativoEnum ativo;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Visitante visitante;
	
	public VeiculoVisitante(VeiculoVisitanteDTO dto){
		super();
		this.id = dto.getId();
		this.placa = dto.getPlaca();
		this.modelo = dto.getModelo();
		this.cor = dto.getCor();
		this.ativo = dto.getAtivo();
		this.visitante = dto.getVisitante() != null ? new Visitante(dto.getVisitante()): null;
	}
		
	public String getVeiculoConcat(){
		return getModelo()+" - "+getPlaca();
	}
	
	public VeiculoVisitante() {
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
	
	

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public List<VeiculoVisitante> convertToList(List<VeiculoVisitanteDTO> lista){
		List<VeiculoVisitante> veiculos = new ArrayList<>();
		if(!lista.isEmpty()){
			for (VeiculoVisitanteDTO v : lista) {
				VeiculoVisitante veiculo = new VeiculoVisitante(v);
				veiculos.add(veiculo);
			}
		}
		return veiculos;
	}

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}
	
}
