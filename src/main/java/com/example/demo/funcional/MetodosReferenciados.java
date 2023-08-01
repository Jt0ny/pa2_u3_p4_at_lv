package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);
	
	public Integer getID() {
		return 8;
	}

	public void aceptar(String arg) {
		String cadena="Anthony";
		LOG.info(cadena+""+arg);
	};
	
	public boolean evaluar (Integer arg) {
		if (arg==2) {
			return true;
		}else {
			return false;
		}
			
	};
	
	public String aplicar(Integer arg) {
		String cadena = arg.toString().concat("Numero transformado a String");
		return cadena;
	}
	public Integer aplicar2( Integer arg) {
		Integer suma= 10+arg;
	 return suma;	
	}
}
