package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG= LoggerFactory.getLogger(MetodosHighOrder.class);
	
	//supplier
	public static void metodo(IPersonaSupplier<String>funcion) {
		funcion.getID();
		LOG.info("High Order Suplier"+funcion.getID());
	}
	
	//consumer
	public static void metodo2(IPersonaConsumer<String>funcion,String cadena) {
		funcion.accept(cadena);
	}
	
	//predicate 
	public static void metodo3(IPersonaPredicate<Integer>num,Integer arg) {
		num.evaluar(arg);
		LOG.debug("High Order predicate:");

		
	}
	
}
