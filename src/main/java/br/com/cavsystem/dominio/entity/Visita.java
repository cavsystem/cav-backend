package br.com.cavsystem.dominio.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.cavsystem.dominio.entity.dto.VisitaDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.dominio.enums.TipoAcessoEnum;
import br.com.cavsystem.dominio.enums.TipoVisitaEnum;

@Entity
public class Visita {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraSaida;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Condominio condominio;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Cartao cartao;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Visitante visitante;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Apartamento apartamento;
	
	@Enumerated(EnumType.STRING)
	private TipoVisitaEnum tipoVisita;
	
	@Enumerated(EnumType.STRING)
	private TipoAcessoEnum tipoAcesso;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private VeiculoVisitante veiculo;

	@Enumerated(EnumType.STRING)
	private AtivoInativoEnum ativo;
			
	public String getDataInicioForamtada() {
		SimpleDateFormat dataFormato = new SimpleDateFormat(
				"dd/MM/yyyy - HH:mm");
		if (dataHoraSaida != null) {
			return dataFormato.format(dataHoraSaida);
		}
		return "Presente";
	}
	
	public Visita(VisitaDTO dto) {
		super();
		this.id = dto.getId() != null ? dto.getId() : null;
		this.descricao = dto.getDescricao();
		this.dataHoraEntrada = dto.getDataHoraEntrada();
		this.dataHoraSaida = dto.getDataHoraSaida();
		this.condominio = dto.getCondominio() != null ? new Condominio(dto.getCondominio()) : null;
		this.cartao = dto.getCartao() != null ? new Cartao(dto.getCartao()) : null;
		this.visitante = dto.getVisitante() != null ? new Visitante(dto.getVisitante()) : null;
		this.apartamento = dto.getApartamento() != null ? new Apartamento(dto.getApartamento()) : null;
		this.tipoVisita = dto.getTipoVisita();
		this.tipoAcesso = dto.getTipoAcesso();
		this.veiculo = dto.getVeiculo() != null ? new VeiculoVisitante(dto.getVeiculo()) : null;
		this.ativo = dto.getAtivo();
	}

	public Visita() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public TipoVisitaEnum getTipoVisita() {
		return tipoVisita;
	}

	public void setTipoVisita(TipoVisitaEnum tipoVisita) {
		this.tipoVisita = tipoVisita;
	}

	public TipoAcessoEnum getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcessoEnum tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public VeiculoVisitante getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoVisitante veiculo) {
		this.veiculo = veiculo;
	}

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
}
