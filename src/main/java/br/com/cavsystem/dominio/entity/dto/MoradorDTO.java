package br.com.cavsystem.dominio.entity.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.cavsystem.dominio.entity.Morador;



public class MoradorDTO {

	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String contato_1;
	
	private String contato_2;
	
	private UsuarioDTO usuario;
	
	private ApartamentoDTO apartamento;
		
	public MoradorDTO(Morador morador) {
		super();
		this.id = morador.getId();
		this.nome = morador.getNome();
		this.cpf = morador.getCpf();
		this.contato_1 = morador.getContato_1();
		this.contato_2 = morador.getContato_2();
		this.usuario = morador.getUsuario() != null ? new UsuarioDTO(morador.getUsuario()) : null ;
		this.apartamento = morador.getApartamento() != null ? new ApartamentoDTO(morador.getApartamento()) : null;
	}

	public MoradorDTO() {
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

	public String getContato_1() {
		return contato_1;
	}

	public void setContato_1(String contato_1) {
		this.contato_1 = contato_1;
	}

	public String getContato_2() {
		return contato_2;
	}

	public void setContato_2(String contato_2) {
		this.contato_2 = contato_2;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ApartamentoDTO getApartamento() {
		return apartamento;
	}

	public void setApartamento(ApartamentoDTO apartamento) {
		this.apartamento = apartamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<MoradorDTO> converteToMoradorDTO(List<Morador> morador){
		List<MoradorDTO> dtos = new ArrayList<>();
		for (Morador ud : morador) {
		MoradorDTO d = new MoradorDTO(ud);	
			dtos.add(d);
		}
		return dtos;		
	}
}
