package br.com.cavsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.cavsystem.service.InicializaService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private InicializaService service;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("INIT - VERIFICA - BASE");
		service.cadastraAutorizacoes();
		System.out.println("############################");
		System.out.println("############################");
		
	}

}
