package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.PropietarioService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	@Autowired
	private PropietarioService propietarioService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("main:"+TransactionSynchronizationManager.isActualTransactionActive());
		
		Propietario p= new Propietario();
		p.setNombre("Anthony");
		p.setApellido("Tipan");
		p.setCedula("123");
		
		this.propietarioService.guardar(p);
		 
		 
		
		
		
		
		
	}

}
