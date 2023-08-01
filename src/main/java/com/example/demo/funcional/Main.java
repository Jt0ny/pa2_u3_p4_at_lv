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
		
		//Metodos Referenciados
		MetodosReferenciados metodos=new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4=metodos::getID;
		LOG.info("Supplier metodo referenciado:"+supplier4.getID() );	
		
		//2. CONSUMER
		
		//Clases
		IPersonaConsumer<String > consumer1=new PersonaConsumerImpl();
		LOG.info("Consumer clase:");
		consumer1.accept("Anthony Tipan");
		
		//Lambdas
		IPersonaConsumer<String> consumer2=cadena->{
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer Lambda:");
		consumer2.accept("Anthony Tipan2");
		
		//Metodos Referenciados
		IPersonaConsumer<String>consumer3=metodos::aceptar;
		LOG.info("Consumer metodos referenciados:");
		consumer3.accept("Anthony Tipan2");
		
		//3.Predicate
		//Lambdas
		IPersonaPredicate<Integer>predicate1=valor -> valor.compareTo(8)==0;
		LOG.info("Predicate lambda:"+predicate1.evaluar(8));

		IPersonaPredicate<Integer>predicate2=valor -> {
			Integer valor2=10;
			valor=valor+valor2;
			if(valor.compareTo(100)>0)	{
				return true;
				
			}else
				return false;
		};
		LOG.info("Predicate lambda2:"+predicate2.evaluar(95));
		
		IPersonaPredicate<String>predicate3=caracter ->"Anthony".contains(caracter);
		LOG.info("Predicate lambda3:"+predicate3.evaluar("n"));
		
		IPersonaBIPredicate<String,String>predicate4=(caracter,cadena) ->cadena.contains(caracter);
		LOG.info("Predicate lambda4:"+predicate4.evaluar("y","Anthony"));
		
		//Metodos Referenciados
		
		IPersonaPredicate<Integer>predicate5=metodos::evaluar;
		LOG.info("Predicate metodos referenciados:"+predicate5.evaluar(2));
		
		//3.Function
		
		IPersonaFunction<String, Integer> function=numero->numero.toString();
		LOG.info("Function lambda1:"+function.aplicar(8));
		
		IPersonaFunction<String, Integer> function1=numero->{
			String valorFinal=numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Function lambda2:"+function1.aplicar(10));
		
		//Metodos Referenciados
		IPersonaFunction<String, Integer> function2=metodos::aplicar;
		LOG.info("Function metodos referenciados:"+function2.aplicar(85));
		
		
		//5.UnaryOperator
		IPersonaUnary<Integer>unary=numero->numero+(numero*2);
		LOG.info("Unary lambda:"+unary.aplicar(3));
		
		IPersonaUnaryFunction<Integer>unary2=numero->numero+(numero*2);
		LOG.info("Unary lambda2:"+unary2.aplicar(3));
		
		//Metodos Referenciados
		IPersonaUnary<Integer>unary3=metodos::aplicar2;
		LOG.info("Unary metodos referenciados:"+unary3.aplicar(100));
		
		
		
				
		
	
	
	}}
