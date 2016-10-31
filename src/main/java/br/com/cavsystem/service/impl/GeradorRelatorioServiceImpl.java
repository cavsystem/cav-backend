package br.com.cavsystem.service.impl;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.entity.Morador;
import br.com.cavsystem.dominio.entity.VeiculoMorador;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.GeradorRelatorioService;
import br.com.cavsystem.util.UtilJasperReports;


@Service("geradorRelatorioService")
public class GeradorRelatorioServiceImpl implements GeradorRelatorioService  {
	


	@Override
	public byte[] gerarRelatorioMorador(List<Morador> moradores, String realPath, String usuario, String condominio) throws BusinessException {
		
		byte[] 	arquivoPDF = null;
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			
	        params.put("logo", realPath + "/logo.png");
	        params.put("data", dataFormato.format(new Date()));
	        params.put("usuario", usuario);
	        params.put("condominio", condominio);
	        
			arquivoPDF = UtilJasperReports.criarRelatorioPdf((realPath +"/relatorio_moradores.jasper"), moradores, params);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return arquivoPDF;
	}
	
	@Override
	public byte[] gerarRelatorioVeiculoMorador(List<VeiculoMorador> veiculos, String realPath, String usuario, String condominio) throws BusinessException {
		
		
		byte[] 	arquivoPDF = null;
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			
	        params.put("logo", realPath + "/logo.png");
	        params.put("data", dataFormato.format(new Date()));
	        params.put("usuario", usuario);
	        params.put("condominio", condominio);
	        
	        
	       
	        
	        
			arquivoPDF = UtilJasperReports.criarRelatorioPdf((realPath +"/relatorio_veiculos_moradores.jasper"), veiculos, params);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return arquivoPDF;
	}


	
	@Override
	public byte[] gerarOcorrencia(String titulo, String realPath, 
			String usuario, String condominio, String login, 
			Date dataOcorrencia, Date dataCadastro,String descricao) throws BusinessException {
		
		byte[] 	arquivoPDF = null;
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dataTimeFormato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			
	        params.put("logo", realPath + "/logo.png");
	        params.put("data", dataTimeFormato.format(new Date()));
	        params.put("usuario", usuario);
	        params.put("condominio", condominio);
	        params.put("titulo", titulo);
	        params.put("usuarioCriador", login);
	        params.put("dataOcorrencia", dataFormato.format(dataOcorrencia));
	        params.put("dataCadastro", dataFormato.format(dataCadastro));
	        params.put("descricao", descricao);
	        
			arquivoPDF = UtilJasperReports.criarRelatorioPdf((realPath +"/ocorrencia.jasper"),null, params);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return arquivoPDF;
	}








	@Override
	public byte[] gerarRelatorioCorrespondencias(
			List<Correspondencia> correspondencias, String realPath,String usuario, String condominio) throws BusinessException {
		byte[] 	arquivoPDF = null;
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			
	        params.put("logo", realPath + "/logo.png");
	        params.put("data", dataFormato.format(new Date()));
	        params.put("usuario", usuario);
	        params.put("condominio", condominio);
	        
			arquivoPDF = UtilJasperReports.criarRelatorioPdf((realPath +"/relatorio_correspondencia.jasper"), correspondencias, params);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return arquivoPDF;
	}
	








	@Override
	public byte[] gerarRelatorioVisitas(List<Visita> Visitas, String realPath,
			String usuario, String condominio) throws BusinessException {
		byte[] 	arquivoPDF = null;
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			
	        params.put("logo", realPath + "/logo.png");
	        params.put("data", dataFormato.format(new Date()));
	        params.put("usuario", usuario);
	        params.put("condominio", condominio);
	        
			arquivoPDF = UtilJasperReports.criarRelatorioPdf((realPath +"/relatorio_visitas.jasper"), Visitas, params);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return arquivoPDF;
	}
}
