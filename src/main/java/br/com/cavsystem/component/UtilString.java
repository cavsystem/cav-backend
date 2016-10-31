package br.com.cavsystem.component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public final class UtilString {

	/**
	 * Construtor privado
	 */
	private UtilString() {
	}

	/**
	 * Verifica se a String contem valor e é diferente de nulo.
	 * 
	 * @param text
	 *            String a ser testada
	 * @return
	 */
	public static boolean isNotEmpty(String text) {
		return text != null && !text.trim().isEmpty();
	}

	/**
	 * Verifica se a String esta vazia e é diferente de nulo.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

	/**
	 * Verifica se o valor é numerico.
	 * 
	 * @param valor
	 *            Object - Valor a ser verificado
	 * @return
	 */

	public static boolean isNumber(Object valor) {
		try {
			StringUtils.isNumeric(valor.toString());
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * Preenche de espaços a direita no texto.
	 * 
	 * @param tamanho
	 *            int - Quantidade de espaços a ser preenchidos.
	 * @return
	 */

	private static String fillerText(int tamanho) {
		return fillRight("", ' ', tamanho);
	}

	/**
	 * Preenche o texto com o caracter a ser informado e sua quantidade.
	 * 
	 * @param fill
	 *            char - Caracter a ser informado.
	 * @param tamanho
	 *            int - Quantidade a ser preenchida.
	 * @return
	 */

	private static String fillerText(char fill, int tamanho) {
		return fillRight("", fill, tamanho);
	}

	/**
	 * Preenche de zeros a direita de acordo com a quantidade.
	 * 
	 * @param tamanho
	 *            int - quantidade a ser preenchida.
	 * @return
	 */

	private static String fillerNumber(int tamanho) {
		return fillRight("", '0', tamanho);
	}

	/**
	 * Formata o número em campos com casas decimais.
	 * 
	 * 
	 * @param valor
	 *            Number a ser formatado, valor default: 0.
	 * @param inteiros
	 *            Integer quantidade de casas inteiras, valor default: 12.
	 * @param decimais
	 *            Integer quantidade de casas decimais, valor default: 2.
	 * @return
	 */
	public static String formatDecimalNumber(Number valor, Integer inteiros, Integer decimais) {
		if (valor == null) {
			valor = 0;
		}

		if (inteiros == null) {
			inteiros = 12;
		}

		if (decimais == null) {
			decimais = 2;
		}

		DecimalFormat decimalFormater = new DecimalFormat();
		decimalFormater.setMaximumFractionDigits(decimais);
		decimalFormater.setMinimumFractionDigits(decimais);
		decimalFormater.setMinimumIntegerDigits(inteiros);
		decimalFormater.setMaximumIntegerDigits(inteiros);
		return decimalFormater.format(valor).replaceAll("\\.", "").replaceAll(",", "");

	}

	/**
	 * Insere caracteres a esquerda da variavel.
	 * 
	 * @param dsValorAlterar
	 *            String Valor inicial a ser alterado. default: "".
	 * @param dsCaracter
	 *            char Caracter a ser inserido.
	 * @param nrTamanho
	 *            int Quantidade de caracteres a serem inseridos.
	 * @return
	 */

	public static String fillLeft(String dsValorAlterar, char dsCaracter, int nrTamanho) {

		if (dsValorAlterar == null || "".equals(dsValorAlterar.trim())) {
			dsValorAlterar = "";
		}
		dsValorAlterar = dsValorAlterar.replaceAll("[./-]", "");
		StringBuffer sb = new StringBuffer(dsValorAlterar);

		for (int i = 0; i < nrTamanho; i++) {
			sb.insert(0, dsCaracter);
		}

		return sb.toString();
	}

	/**
	 * Insere caracteres a direita da variavel.
	 * 
	 * @param dsValorAlterar
	 *            String Valor inicial a ser alterado. default: "".
	 * @param dsCaracter
	 *            char Caracter a ser inserido.
	 * @param nrTamanho
	 *            int Quantidade de caracteres a serem inseridos.
	 * @return
	 */

	public static String fillRight(String dsValorAlterar, char dsCaracter, int nrTamanho) {

		if (dsValorAlterar == null || "".equals(dsValorAlterar.trim())) {
			dsValorAlterar = "";
		}
		dsValorAlterar = dsValorAlterar.replaceAll("[./-]", "");
		StringBuffer sb = new StringBuffer(dsValorAlterar);
		
		for (int i = 0; i < nrTamanho; i++) {
			sb.append(dsCaracter);
		}
		return sb.toString();
	}

	/**
	 * Retira a formatação numérica. Ex: ponto e virgula.
	 * 
	 * @param value
	 * @param tamanho
	 * @param scale
	 * @return
	 */

	public static String removeDecimalFormatting(Number value, int tamanho, int scale) {
		if (value == null)
			return fillRight("", '0', tamanho);
		else {
			BigDecimal newValue;
			if (value instanceof BigDecimal) {
				newValue = (BigDecimal) value;
			} else {
				newValue = new BigDecimal(value.doubleValue());
			}
			newValue = newValue.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
			value = newValue.unscaledValue();

			return formatNumber(String.valueOf(value), tamanho);
		}
	}

	/**
	 * Preenche de zeros a esquerda.
	 * 
	 * @param value
	 *            String - Valor a ser preenchido.
	 * @param tamanho
	 *            int - Quantidade a ser preenchida.
	 * @return
	 */
	public static String formatNumber(String value, int tamanho) {
		if (value == null)
			return fillerNumber(tamanho);
		else {
			if (value.length() > tamanho)
				return value.substring(0, tamanho);
			else
				return fillLeft(value, '0', tamanho);
		}
	}

	/**
	 * Formata o texto em um tamanho especifico.
	 * 
	 * @param value
	 *            String - Valor a ser formatado.
	 * @param tamanho
	 *            int - Tamanho especifico.
	 * @return
	 */
	public static String formatText(String value, int tamanho) {
		if (value == null)
			return fillerText(tamanho);
		else {
			String valueCerto = null;

			// verifica se o texto é maior que o necessário e coloca em
			if (value.length() > tamanho)
				valueCerto = value.substring(0, tamanho);
			else
				valueCerto = value;

			return fillRight(valueCerto, ' ', tamanho);
		}
	}

	/**
	 * Transforma a data conforme layout a ser passado e com tamanho
	 * pre-determinado.
	 * 
	 * 
	 * @param value
	 *            Date - Data a ser transformada.
	 * @param tamanho
	 *            int - tamanho pre-determinado.
	 * @param format
	 *            String - Layout de formatação.
	 * @return
	 */
	public static String formatDate(Date value, int tamanho, String format) {
		if (value == null)
			return fillerNumber(tamanho);
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		return formatText(formatDate.format(value), tamanho);
	}

	public static void main(String[] args) {
		System.out.println(UtilString.removeDecimalFormatting(new BigDecimal(10000.00), 3, 2)
				.equalsIgnoreCase("100"));
	}
	
	public static String cutMaxSize(String text, int maxSize) {
		if (text == null) {
			return null;
		}
		if (text.length() <= maxSize) {
			return text; 
		} else {
			return text.substring(0, maxSize);
		}
	}
	
	/**
	 * Retira a mascara do valor informado
	 * 
	 * @param dado
	 * @return String
	 */
	public static String retiraMascara(String dado) {
		StringBuffer retorno = new StringBuffer("");
		if (dado != null) {
			for (int a = 0; a < dado.length(); a++) {
				if (dado.charAt(a) != '.' && dado.charAt(a) != '/'
						&& dado.charAt(a) != '-' && dado.charAt(a) != ',' 
							&& dado.charAt(a) != '+') {
					retorno.append(dado.charAt(a));
				}
			}
		}
		return retorno.toString();
	}
}
