package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.Plano;
import br.com.cavsystem.dominio.enums.SimNaoEnum;


public class PlanoDTO {

	private Long id;
	
	private String nome;
	
	private int numeroAdministradores;
	
	private int numeroPorteiros;
	
	private int numeroMoradores;
	
	private SimNaoEnum aplicativo;
	
	public PlanoDTO(Plano plano) {
		super();
		this.id = plano.getId();
		this.nome = plano.getNome();
		this.numeroAdministradores = plano.getNumeroAdministradores();
		this.numeroPorteiros = plano.getNumeroPorteiros();
		this.numeroMoradores = plano.getNumeroMoradores();
		this.aplicativo = plano.getAplicativo();
	}

	public PlanoDTO() {
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

	public int getNumeroAdministradores() {
		return numeroAdministradores;
	}

	public void setNumeroAdministradores(int numeroAdministradores) {
		this.numeroAdministradores = numeroAdministradores;
	}

	public int getNumeroPorteiros() {
		return numeroPorteiros;
	}

	public void setNumeroPorteiros(int numeroPorteiros) {
		this.numeroPorteiros = numeroPorteiros;
	}

	public int getNumeroMoradores() {
		return numeroMoradores;
	}

	public void setNumeroMoradores(int numeroMoradores) {
		this.numeroMoradores = numeroMoradores;
	}

	public SimNaoEnum getAplicativo() {
		return aplicativo;
	}

	public void setAplicativo(SimNaoEnum aplicativo) {
		this.aplicativo = aplicativo;
	}
		
}
