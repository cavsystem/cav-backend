package br.com.cavsystem.dominio.entity.dto;

import java.util.Date;

import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.enums.SimNaoEnum;
import br.com.cavsystem.dominio.enums.TipoCorrespondenciaEnum;


public class CorrespondeciaDTO {

	private Long id;
	
	private String numeroCodigoBarras;
	
	private String remetente;
	
	private TipoCorrespondenciaEnum tipo;
	
	private ApartamentoDTO correspondeciaPara;
	
	private Date dataRecebimento;
	
	private SimNaoEnum liberado;
	
	private String liberadoPara;
	
	private Date dataLiberacao;
	

	
	public CorrespondeciaDTO(Correspondencia correspondencia) {
		super();
		this.id = correspondencia.getId();
		this.numeroCodigoBarras = correspondencia.getNumeroCodigoBarras();
		this.remetente = correspondencia.getRemetente();
		this.tipo = correspondencia.getTipo();
		this.correspondeciaPara = new ApartamentoDTO(correspondencia.getCorrespondeciaPara());
		this.dataRecebimento = correspondencia.getDataRecebimento();
		this.liberado = correspondencia.getLiberado();
		this.liberadoPara = correspondencia.getLiberadoPara();
		this.dataLiberacao = correspondencia.getDataLiberacao();
	}

	public CorrespondeciaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCodigoBarras() {
		return numeroCodigoBarras;
	}

	public void setNumeroCodigoBarras(String numeroCodigoBarras) {
		this.numeroCodigoBarras = numeroCodigoBarras;
	}

	public TipoCorrespondenciaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoCorrespondenciaEnum tipo) {
		this.tipo = tipo;
	}

	public ApartamentoDTO getCorrespondeciaPara() {
		return correspondeciaPara;
	}

	public void setCorrespondeciaPara(ApartamentoDTO correspondeciaPara) {
		this.correspondeciaPara = correspondeciaPara;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public SimNaoEnum getLiberado() {
		return liberado;
	}

	public void setLiberado(SimNaoEnum liberado) {
		this.liberado = liberado;
	}
	
	public String getLiberadoPara() {
		return liberadoPara;
	}

	public void setLiberadoPara(String liberadoPara) {
		this.liberadoPara = liberadoPara;
	}

	public Date getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(Date dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

}
