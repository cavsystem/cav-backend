package br.com.cavsystem.exception.mensagem;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.cavsystem.component.UtilString;




/**
 * Representa uma mensagem.
 * 
 * @author Rodrigo 
 * 
 *         Alteração na classe para contemplar os atributos da excessao json
 * 
 */
public class MessageDefault implements Message {

	private static final long serialVersionUID = -3226938241649899645L;

	private String sistema;

	private String origemErro;

	private String paragrafoErro;

	private String categoriaErro;

	private String codigoErro;

	private List<String> mensagemNegocial;

	private List<String> mensagemErro;

	private int severidade;
	
	private String severidadeDescricao;

	private String informacoesAdicionais;



	public Message getMessage(String msg) {
		MessageDefault message = null;
		try {
			if (UtilString.isNotEmpty(msg)) {
				Gson gson = new Gson();
				message = gson.fromJson(msg, MessageDefault.class);
			} else {
				message = new MessageDefault();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public String getSistema() {
		return this.sistema;
	}

	public String getOrigemErro() {
		return this.origemErro;
	}

	public void setOrigemErro(String origemErro) {
		this.origemErro = origemErro;
	}

	public String getParagrafoErro() {
		return this.paragrafoErro;
	}

	public void setParagrafoErro(String paragrafoErro) {
		this.paragrafoErro = paragrafoErro;
	}

	public String getCategoriaErro() {
		return this.categoriaErro;
	}

	public void setCategoriaErro(String categoriaErro) {
		this.categoriaErro = categoriaErro;
	}

	public String getCodigoErro() {
		return this.codigoErro;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public void setCodigoErro(String codigoErro) {
		this.codigoErro = codigoErro;
	}

	public List<String> getMensagemNegocial() {
		if (mensagemNegocial == null) {
			mensagemNegocial = new ArrayList<String>();
		}
		return this.mensagemNegocial;
	}

	public void setMensagemNegocial(List<String> mensagemNegocial) {
		this.mensagemNegocial = mensagemNegocial;
	}

	public List<String> getMensagemErro() {
		if (this.mensagemErro == null) {
			this.mensagemErro = new ArrayList<String>();
		}
		return this.mensagemErro;
	}

	public void setMensagemErro(List<String> mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public int getSeveridade() {
		return this.severidade;
	}

	public void setSeveridade(int i) {
		this.severidade = i;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	
	public String getSeveridadeDescricao() {
		return this.severidadeDescricao;
	}
	
	public void setSeveridadeDescricao(String severidadeDescricao) {
		this.severidadeDescricao = severidadeDescricao;
	}

	@Override
	public String toString() {
		return "MessageDefault [sistema=" + sistema + ", origemErro="
				+ origemErro + ", paragrafoErro=" + paragrafoErro
				+ ", categoriaErro=" + categoriaErro + ", codigoErro="
				+ codigoErro + ", mensagemNegocial=" + mensagemNegocial
				+ ", mensagemErro=" + mensagemErro + ", severidade="
				+ severidade + ", severidadeDescricao=" + severidadeDescricao
				+ ", informacoesAdicionais=" + informacoesAdicionais + "]";
	}
	
	
}
