package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);
	
	//supplier
	public static Integer getID() {
		return 8;
	}

	//consumer
	public  static void aceptar(String arg) {
		String cadena="Anthony";
		LOG.info(cadena+""+arg);
	};
	
	//predicate 
	public static boolean evaluar (Integer arg) {
		if (arg==2) {
			return true;
		}else {
			return false;
		}
			
	};
	
	//function
	public static String aplicar(Integer arg) {
		String cadena = arg.toString().concat("Numero transformado a String");
		return cadena;
	}
	
	//Unary
	public static Integer aplicar2( Integer arg) {
		Integer suma= 10+arg;
	 return suma;	
	}
	public static String unary( String arg) {
		String union="UNARY".concat(arg);
	 return union;	
	}
	
	public static String getIDHO() {
		LOG.info("Metodos referenciados y HO");
		return "Anthony Tipan";
	}
	
	/*//Metodos del deber 16
	//SUPPLIER
		public static String metodoS() {
			return "Ejemplo Supplier";
			
		}
		
	//CONSUMER
		public static void metodoC(Integer arg) {
			LOG.info("Ejemplo Consumer:"+arg.toString());
		}
		
	//PREDICATE
		public static boolean metodoP (Integer arg) {
			if (arg.compareTo(2) == 0) {
				LOG.info("Ejemplo Predicate:"+arg);
				return true;
			} else {
				LOG.info("Ejemplo Predicate:"+arg);
				return false;
			}
		}
		
	//FUNCTION
		public static String metodoF(Integer arg) {
			LOG.info("Ejemplo Function:"+arg);
			String valorF = arg.toString().concat(" valor en String");
			return valorF;
		}
		
	//UnaryOperator
		public static Integer metodoU(Integer arg) {
			Integer sum=arg+10;
			return sum;
		}*/

}
