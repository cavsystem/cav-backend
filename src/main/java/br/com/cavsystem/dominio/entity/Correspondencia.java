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
import br.com.cavsystem.dominio.entity.dto.CorrespondeciaDTO;
import br.com.cavsystem.dominio.enums.SimNaoEnum;
import br.com.cavsystem.dominio.enums.TipoCorrespondenciaEnum;

@Entity
public class Correspondencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String numeroCodigoBarras;
	
	private String remetente;
	
	@Enumerated(EnumType.STRING)
	private TipoCorrespondenciaEnum tipo;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Apartamento correspondeciaPara;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRecebimento;
	
	@Enumerated(EnumType.STRING)
	private SimNaoEnum liberado;
	
	private String liberadoPara;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataLiberacao;
		
	
	
	public String getRecebimentoFormatado() {
		SimpleDateFormat dataFormato = new SimpleDateFormat(
				"dd/MM/yyyy - HH:mm");
		if (dataRecebimento != null) {
			return dataFormato.format(dataRecebimento);
		}
		return "Sem data";
	}
	
	public String getLiberacaoFormatado() {
		SimpleDateFormat dataFormato = new SimpleDateFormat(
				"dd/MM/yyyy - HH:mm");
		if (dataLiberacao != null) {
			return dataFormato.format(dataLiberacao);
		}
		return "------";
	}
	
	
	
	public Correspondencia(CorrespondeciaDTO dto) {
		super();
		this.id = dto.getId();
		this.numeroCodigoBarras = dto.getNumeroCodigoBarras();
		this.remetente = dto.getRemetente();
		this.tipo = dto.getTipo();
		this.correspondeciaPara = new Apartamento(dto.getCorrespondeciaPara());
		this.dataRecebimento = dto.getDataRecebimento();
		this.liberado = dto.getLiberado();
		this.liberadoPara = dto.getLiberadoPara();
		this.dataLiberacao = dto.getDataLiberacao();
	}

	public Correspondencia() {
		super();
	}
	
	public String getTipoNome(){
		if(tipo.getValor() == "E"){
			return "Envelope";
		}else if(tipo.getValor() == "P"){
		return "Pacote";
		}else{
			return "Não Informado";
		}
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

	public Apartamento getCorrespondeciaPara() {
		return correspondeciaPara;
	}

	public void setCorrespondeciaPara(Apartamento correspondeciaPara) {
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
