package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.CuentaBancariaService;

@SpringBootApplication
@EnableAsync //habilitar el proceso asincrono 
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	private static final Logger LOG= LoggerFactory.getLogger(Pa2U3P4AtLvApplication.class);

	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//ASINCRONO SIN RESPUESTA
		/*LOG.info("Hilo:"+Thread.currentThread().getName());
		
		//inicio
       long tiempoInicial=System.currentTimeMillis();
       List<CuentaBancaria>lista=new ArrayList<>();
        for(int i =0;i<=10;i++) {
        	CuentaBancaria cue= new CuentaBancaria();
    		cue.setNumero("17");
    		cue.setSaldo(new BigDecimal(800));
    		cue.setTipo("Ahorros");
    		lista.add(cue);
    		this.cuentaBancariaService.agregarAsincrono(cue);
        }
        
       // List<String>listafinal= lista.parallelStream().map(cta->this.cuentaBancariaService.guardar2(cta)).collect( Collectors.toList());
        //LOG.debug("Se guardaron las siguientes cuentas");
       // listafinal.forEach(cadena->LOG.debug(cadena));
        //fin
        long tiempoFinal=System.currentTimeMillis();
        long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
        LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
        LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );
        
        LOG.debug("Se termino de procesar todo");*/
        
        //ASINCRONO CON FUTURO CON RESPUESTA
		LOG.info("Hilo:"+Thread.currentThread().getName());
		
		//inicio
       long tiempoInicial=System.currentTimeMillis();
       List<CompletableFuture<String>>listarespuestas=new ArrayList<>();
       List<CuentaBancaria>lista=new ArrayList<>();
        for(int i =0;i<=10;i++) {
        	CuentaBancaria cue= new CuentaBancaria();
    		cue.setNumero("17");
    		cue.setSaldo(new BigDecimal(800));
    		cue.setTipo("Ahorros");
    		lista.add(cue);
    		CompletableFuture<String>respuesta=this.cuentaBancariaService.agregarAsincrono2(cue);
    		listarespuestas.add(respuesta);
        }
        //Sentencia que espera que termine de procesarse todos los hilos a para obtener la respuesta
        CompletableFuture.allOf(listarespuestas.get(0),listarespuestas.get(1),listarespuestas.get(2)
        ,listarespuestas.get(3),listarespuestas.get(4),listarespuestas.get(5),listarespuestas.get(6)
        ,listarespuestas.get(7),listarespuestas.get(8),listarespuestas.get(9));
 
        LOG.info("Respuesta 0:"+ listarespuestas.get(0).get());

        
        //fin
        long tiempoFinal=System.currentTimeMillis();
        long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
        LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
        LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );
        
        LOG.debug("Se termino de procesar todo");

		

	

		
		 
		 
		
		
		
		
		
	}

}
