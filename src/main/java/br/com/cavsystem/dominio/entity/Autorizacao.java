package br.com.cavsystem.dominio.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.cavsystem.dominio.entity.dto.AutorizacaoDTO;
import br.com.cavsystem.dominio.enums.RoleAcesso;

@Entity
public class Autorizacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleAcesso nome;

 		
	public Autorizacao(AutorizacaoDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
	}

	public Autorizacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleAcesso getNome() {
		return nome;
	}

	public void setNome(RoleAcesso nome) {
		this.nome = nome;
	}

	
	public List<Autorizacao> convertTo(List<AutorizacaoDTO> dtos){
		List<Autorizacao> auts = new ArrayList<Autorizacao>();
		for (AutorizacaoDTO dto : dtos) {
			Autorizacao adto = new Autorizacao(dto);
			auts.add(adto);
		}
		return auts;
	}
	
}
