package br.com.cavsystem.dominio.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.cavsystem.dominio.entity.dto.OcorrenciaDTO;

@Entity
public class Ocorrencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Condominio condominio;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Usuario usuarioCriador;
	
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;
	
	@Temporal(TemporalType.DATE)
	private Date dataOcorrencia;
		
	@ManyToOne(cascade=CascadeType.DETACH)
	private Apartamento unidadeEnvolvida;
	
	private String titulo;
	
	@Lob
	private String descricao;
	

	public Ocorrencia(OcorrenciaDTO dto) {
		super();
		this.id = dto.getId();
		this.condominio = dto.getCondominio() != null ? new Condominio(dto.getCondominio()) : null;
		this.usuarioCriador = dto.getUsuarioCriador() != null ? new Usuario(dto.getUsuarioCriador()) : null;
		this.dataRegistro = dto.getDataRegistro();
		this.dataOcorrencia = dto.getDataOcorrencia();
		this.unidadeEnvolvida = dto.getUnidadeEnvolvida() != null ? new Apartamento(dto.getUnidadeEnvolvida()) : null;
		this.titulo = dto.getTitulo();
		this.descricao = dto.getDescricao();
	}

	public Ocorrencia() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
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

	public Apartamento getUnidadeEnvolvida() {
		return unidadeEnvolvida;
	}

	public void setUnidadeEnvolvida(Apartamento unidadeEnvolvida) {
		this.unidadeEnvolvida = unidadeEnvolvida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
