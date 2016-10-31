package br.com.cavsystem.dominio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.cavsystem.dominio.entity.dto.VeiculoMoradorDTO;

@Entity
public class VeiculoMorador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String placa;
	
	private String modelo;
	
	private String cor;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Morador morador;

	
	public VeiculoMorador(VeiculoMoradorDTO dto){
		super();
		this.id = dto.getId();
		this.placa = dto.getPlaca();
		this.modelo = dto.getModelo();
		this.cor = dto.getCor();
		this.morador = dto.getMorador() != null ? new Morador(dto.getMorador()) : null;
	}

	public VeiculoMorador() {
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
	
	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	public List<VeiculoMorador> convertToList(List<VeiculoMoradorDTO> lista){
		List<VeiculoMorador> veiculos = new ArrayList<>();
		if(!lista.isEmpty()){
			for (VeiculoMoradorDTO v : lista) {
				VeiculoMorador veiculo = new VeiculoMorador(v);
				veiculos.add(veiculo);
			}
		}
		return veiculos;
	}
	
}
