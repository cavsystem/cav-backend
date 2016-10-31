package br.com.cavsystem.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;


public class UtilJasperReports {
	
	public static byte[] criarRelatorioPdfSemParametros(String nomeDoArquivoDoRelatorio, List<?> dados)
			throws FileNotFoundException, JRException {
		return criarRelatorioPdf(nomeDoArquivoDoRelatorio, dados, null);
	}	
	
	public static byte[] criarRelatorioPdf(String nomeDoArquivoDoRelatorio, List<?> dados,
			Map<String, Object> parametros) throws FileNotFoundException, JRException {
		JasperPrint jasperPrint = montaRelatorioComCollection(nomeDoArquivoDoRelatorio, dados, parametros);
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

	private static JasperPrint montaRelatorioComCollection(String nomeDoArquivoDoRelatorio, List<?> dados,
			Map<String, Object> parametros) throws FileNotFoundException, JRException {
		JasperReport reportCompiled = (JasperReport) JRLoader.loadObject(new File(nomeDoArquivoDoRelatorio));
		parametros = getParametrosPadronizados(parametros);
		JRDataSource dataSource = getDadosPadronizados(dados);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportCompiled, parametros, dataSource);
		return jasperPrint;
	}
	
	private static JRDataSource getDadosPadronizados(List<?> dados) {
		if (dados == null) {
			return new JREmptyDataSource();
		}
		return new JRBeanCollectionDataSource(dados);
	}

	private static Map<String, Object> getParametrosPadronizados(Map<String, Object> parametros) {
		if (parametros == null) {
			parametros = new HashMap<String, Object>();
		}
		return parametros;
	}
}
