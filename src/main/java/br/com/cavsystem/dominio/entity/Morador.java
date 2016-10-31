package br.com.cavsystem.dominio.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.cavsystem.dominio.entity.dto.MoradorDTO;

@Entity
public class Morador{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String contato_1;
	
	private String contato_2;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Apartamento apartamento;
	
	public Morador(MoradorDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.contato_1 = dto.getContato_1();
		this.contato_2 = dto.getContato_2();
		this.usuario = dto.getUsuario() != null ? new Usuario(dto.getUsuario()) : null;
		this.apartamento = dto.getApartamento() != null ? new Apartamento(dto.getApartamento()) : null;
	}

	public Morador() {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Morador> converteToMorador(List<MoradorDTO> dtos){
		List<Morador> usrs = new ArrayList<>();
		for (MoradorDTO ud : dtos) {
		Morador m = new Morador(ud);	
			usrs.add(m);
		}
		return usrs;		
	}
	
}
