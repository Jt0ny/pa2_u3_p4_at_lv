package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG= LoggerFactory.getLogger(MetodosHighOrder.class);
	
	public static void metodo(IPersonaSupplier<String>funcion) {
		funcion.getID();
		LOG.info("High Order Suplier"+funcion.getID());
	}
	
	public static void metodo2(IPersonaConsumer<String>funcion,String cadena) {
		funcion.accept(cadena);
	}
	
}
