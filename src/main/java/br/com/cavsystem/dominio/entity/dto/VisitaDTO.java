package br.com.cavsystem.dominio.entity.dto;

import java.util.Date;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.dominio.enums.TipoAcessoEnum;
import br.com.cavsystem.dominio.enums.TipoVisitaEnum;

public class VisitaDTO {
	
    private Long id;
    
    private Date dataHoraEntrada;

	private Date dataHoraSaida;
	
	private CondominioDTO condominio;
	
	private String descricao; 
	
	private CartaoDTO cartao;
	
	private VisitanteDTO visitante;
	
	private ApartamentoDTO apartamento;
	
	private TipoVisitaEnum tipoVisita;
	
	private TipoAcessoEnum tipoAcesso;
	
	private VeiculoVisitanteDTO veiculo;
	
	private AtivoInativoEnum ativo;
		
	public VisitaDTO(Visita visita) {
		super();
		this.id = visita.getId() != null ? visita.getId(): null; 
		this.dataHoraEntrada = visita.getDataHoraEntrada();
		this.dataHoraSaida = visita.getDataHoraSaida();
		this.descricao = visita.getDescricao();
		this.cartao = visita.getCartao() != null ? new CartaoDTO(visita.getCartao()) : null;
		this.visitante = visita.getVisitante() != null ? new VisitanteDTO(visita.getVisitante()) : null;
		this.apartamento = visita.getApartamento() != null ? new ApartamentoDTO(visita.getApartamento()) : null;
		this.tipoVisita = visita.getTipoVisita();
		this.tipoAcesso = visita.getTipoAcesso();
		this.veiculo = visita.getVeiculo() != null ? new VeiculoVisitanteDTO(visita.getVeiculo()) : null;
		this.ativo = visita.getAtivo();
		this.condominio = visita.getCondominio() != null ? new CondominioDTO(visita.getCondominio()) : null;
	}

	public VisitaDTO() {
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

	public CartaoDTO getCartao() {
		return cartao;
	}

	public void setCartao(CartaoDTO cartao) {
		this.cartao = cartao;
	}

	public VisitanteDTO getVisitante() {
		return visitante;
	}

	public void setVisitante(VisitanteDTO visitante) {
		this.visitante = visitante;
	}

	public ApartamentoDTO getApartamento() {
		return apartamento;
	}

	public void setApartamento(ApartamentoDTO apartamento) {
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

	public VeiculoVisitanteDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoVisitanteDTO veiculo) {
		this.veiculo = veiculo;
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

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}

	public CondominioDTO getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioDTO condominio) {
		this.condominio = condominio;
	}

	
}
