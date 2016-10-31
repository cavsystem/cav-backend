package br.com.cavsystem.dominio.entity.dto;

import java.util.ArrayList;
import java.util.List;





import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.enums.RoleAcesso;

public class AutorizacaoDTO {
	
	private Long id;
	
    private RoleAcesso nome;
	
	public AutorizacaoDTO(Autorizacao autorizacao) {
		super();
		this.id = autorizacao.getId();
		this.nome = autorizacao.getNome();
	}

	public AutorizacaoDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public List<AutorizacaoDTO> convertTo(List<Autorizacao> autorizacoes){
		List<AutorizacaoDTO> dtos = new ArrayList<AutorizacaoDTO>();
		for (Autorizacao a : autorizacoes) {
			AutorizacaoDTO d = new AutorizacaoDTO(a);
			dtos.add(d);
		}
		return dtos;
	}

}
