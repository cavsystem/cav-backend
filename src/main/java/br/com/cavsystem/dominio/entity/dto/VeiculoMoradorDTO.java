package br.com.cavsystem.dominio.entity.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.cavsystem.dominio.entity.VeiculoMorador;

public class VeiculoMoradorDTO {

	private Long id;
	
	private String placa;
	
	private String modelo;
	
	private String cor;
	
	private MoradorDTO morador;

	
	public VeiculoMoradorDTO(VeiculoMorador veiculo) {
		super();
		this.id = veiculo.getId();
		this.placa = veiculo.getPlaca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.morador = veiculo.getMorador() != null ? new MoradorDTO(veiculo.getMorador()) : null;
	}

	public VeiculoMoradorDTO() {
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
	
	public MoradorDTO getMorador() {
		return morador;
	}

	public void setMorador(MoradorDTO morador) {
		this.morador = morador;
	}

	public List<VeiculoMoradorDTO> convertToList(List<VeiculoMorador> lista){
		List<VeiculoMoradorDTO> dtos = new ArrayList<>();
		if(!lista.isEmpty()){
			for (VeiculoMorador v : lista) {
				VeiculoMoradorDTO dto = new VeiculoMoradorDTO(v);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
}
