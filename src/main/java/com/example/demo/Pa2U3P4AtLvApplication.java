package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.PropietarioService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	private static final Logger LOG= LoggerFactory.getLogger(Pa2U3P4AtLvApplication.class);

	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		LOG.info("Hilo:"+Thread.currentThread().getName());
	/*	LOG.info("Hilo:"+Thread.currentThread().getName());// indica el hilo con el que se ejecuta el programa
		
		//inicio
        long tiempoInicial=System.currentTimeMillis();
        for(int i =0;i<=30;i++) {
        	CuentaBancaria cue= new CuentaBancaria();
    		cue.setNumero("17");
    		cue.setSaldo(new BigDecimal(800));
    		cue.setTipo("Ahorros");
    		this.cuentaBancariaService.guardar(cue);
        }
        //fin
        long tiempoFinal=System.currentTimeMillis();
        long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
        LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
        LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );
        */
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		/*
		//inicio
        long tiempoInicial=System.currentTimeMillis();
       List<CuentaBancaria>lista=new ArrayList<>();
        for(int i =0;i<=100;i++) {
        	CuentaBancaria cue= new CuentaBancaria();
    		cue.setNumero("17");
    		cue.setSaldo(new BigDecimal(800));
    		cue.setTipo("Ahorros");
    		lista.add(cue);
        }
        
        //lista.stream().forEach(cta->this.cuentaBancariaService.guardar(cta));
        lista.parallelStream().forEach(cta->this.cuentaBancariaService.guardar(cta));
        
        //fin
        long tiempoFinal=System.currentTimeMillis();
        long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
        LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
        LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );
        */
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		//inicio
       long tiempoInicial=System.currentTimeMillis();
       List<CuentaBancaria>lista=new ArrayList<>();
        for(int i =0;i<=100;i++) {
        	CuentaBancaria cue= new CuentaBancaria();
    		cue.setNumero("17");
    		cue.setSaldo(new BigDecimal(800));
    		cue.setTipo("Ahorros");
    		lista.add(cue);
        }
        
        //lista.stream().forEach(cta->this.cuentaBancariaService.guardar(cta));
        Stream<String>listafinal=  lista.parallelStream().map(cta->this.cuentaBancariaService.guardar2(cta));
        LOG.debug("Se guardaron las siguientes cuentas");
        listafinal.forEach(cadena->LOG.debug(cadena));
        //fin
        long tiempoFinal=System.currentTimeMillis();
        long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
        LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
        LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );

		

	

		
		 
		 
		
		
		
		
		
	}

}
