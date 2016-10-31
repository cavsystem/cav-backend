package br.com.cavsystem.dominio.entity.dto;

import java.util.Date;

import br.com.cavsystem.dominio.entity.Ocorrencia;

public class OcorrenciaDTO {

	private Long id;
	
	private CondominioDTO condominio;
	
	private UsuarioDTO usuarioCriador;
	
	private Date dataRegistro;
	
	private Date dataOcorrencia;
			
	private ApartamentoDTO unidadeEnvolvida;
	
	private String titulo;
	
	private String descricao;

	public OcorrenciaDTO() {
		super();
	}

	public OcorrenciaDTO(Ocorrencia ocorrencia) {
		super();
		this.id = ocorrencia.getId();
		this.condominio =  ocorrencia.getCondominio() != null ? new CondominioDTO(ocorrencia.getCondominio()) : null;
		this.usuarioCriador = new UsuarioDTO(ocorrencia.getUsuarioCriador());
		this.dataRegistro = ocorrencia.getDataRegistro();
		this.dataOcorrencia = ocorrencia.getDataOcorrencia();
		this.unidadeEnvolvida = ocorrencia.getUnidadeEnvolvida() != null ? new ApartamentoDTO(ocorrencia.getUnidadeEnvolvida()) : null;
		this.titulo = ocorrencia.getTitulo();
		this.descricao = ocorrencia.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDTO getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(UsuarioDTO usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public ApartamentoDTO getUnidadeEnvolvida() {
		return unidadeEnvolvida;
	}

	public void setUnidadeEnvolvida(ApartamentoDTO unidadeEnvolvida) {
		this.unidadeEnvolvida = unidadeEnvolvida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CondominioDTO getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioDTO condominio) {
		this.condominio = condominio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
