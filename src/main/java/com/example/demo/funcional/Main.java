package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		Persona per = new PersonaImpl();
		per.caminar();

		//1.- SUPPLIER
		//Clases:
		IPersonaSupplier<String> supplier1= new PersonaSupplierImpl();
		//buena practica para imprimir es un loger (slf4j)
		LOG.info("Supplier clase:"+supplier1.getID() );

		//Lambdas:
		IPersonaSupplier<String> supplier2 = () ->  "17239737966";
		LOG.info("Supplier lambda:"+supplier2.getID() );

		IPersonaSupplier<String> supplier3 = () ->  {
			String cedula="17239737966";
			cedula= cedula+"zzzzzzzzzz";
			return cedula;
		};
		LOG.info("Supplier lambda 2:"+supplier3.getID() );	
		
	}
}
