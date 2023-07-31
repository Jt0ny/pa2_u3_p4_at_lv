package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.PropietarioService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	
	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("main:"+TransactionSynchronizationManager.isActualTransactionActive());
		
		CuentaBancaria cue= new CuentaBancaria();
		cue.setNumero("1017");
		//c1.setPropietario(p1);
		cue.setSaldo(new BigDecimal(700));
		cue.setTipo("Ahorros");
		this.cuentaBancariaService.guardar(cue);
		

		CuentaBancaria c2= new CuentaBancaria ();
		c2.setNumero("180");
		//c2.setPropietario(p2);
		c2.setSaldo(new BigDecimal(800));
		c2.setTipo("Ahorros");
		this.cuentaBancariaService.guardar(c2);

		//Transferencia
		this.transferenciaService.realizarTransferencia("1017", "180", new BigDecimal(100));
		//this.transferenciaService.realizarTransferencia("10", "18", new BigDecimal(440));


		 
		 
		
		
		
		
		
	}

}
