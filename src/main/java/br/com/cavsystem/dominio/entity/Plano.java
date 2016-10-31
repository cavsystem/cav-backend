package br.com.cavsystem.dominio.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.cavsystem.dominio.entity.dto.PlanoDTO;
import br.com.cavsystem.dominio.enums.SimNaoEnum;


@Entity
public class Plano {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private int numeroAdministradores;
	
	private int numeroPorteiros;
	
	private int numeroMoradores;
	
	@Enumerated(EnumType.STRING)
	private SimNaoEnum aplicativo;
	
	public Plano(PlanoDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.numeroAdministradores = dto.getNumeroAdministradores();
		this.numeroPorteiros = dto.getNumeroPorteiros();
		this.numeroMoradores = dto.getNumeroMoradores();
		this.aplicativo = dto.getAplicativo();
	}

	public Plano() {
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
