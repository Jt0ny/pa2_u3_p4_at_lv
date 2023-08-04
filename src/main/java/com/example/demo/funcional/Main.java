package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
	/*	Persona per = new PersonaImpl();
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
		IPersonaSupplier<Integer> supplier4=MetodosReferenciados::getID;
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
		IPersonaConsumer<String>consumer3=MetodosReferenciados::aceptar;
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
		
		IPersonaPredicate<Integer>predicate5=MetodosReferenciados::evaluar;
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
		IPersonaFunction<String, Integer> function2=MetodosReferenciados::aplicar;
		LOG.info("Function metodos referenciados:"+function2.aplicar(85));
		
		
		//5.UnaryOperator
		IPersonaUnary<Integer>unary=numero->numero+(numero*2);
		LOG.info("Unary lambda:"+unary.aplicar(3));
		
		IPersonaUnaryFunction<Integer>unary2=numero->numero+(numero*2);
		LOG.info("Unary lambda2:"+unary2.aplicar(3));
		
		//Metodos Referenciados
		IPersonaUnary<Integer>unary3=MetodosReferenciados::aplicar2;
		LOG.info("Unary metodos referenciados:"+unary3.aplicar(100));
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//Metodos High Order
		MetodosHighOrder highOrder=new MetodosHighOrder();
		//supplier
		//1.Clase
		IPersonaSupplier<String> supplierHO= new PersonaSupplierImpl();
		highOrder.metodo(supplierHO);
		//2.Lambdas
		highOrder.metodo(() ->  "17239737966HO");
		//3.Metodos referenciados
		highOrder.metodo(MetodosReferenciados::getIDHO);
		
		//consumer
		//1.Clase
		highOrder.metodo2(new PersonaConsumerImpl(),"Clase Consumer");
		//2.Lambdas
		highOrder.metodo2(cadena->{
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		},"Lambdas Consumer");
		//3.Metodos referenciados
		highOrder.metodo2(MetodosReferenciados::aceptar,"Metodos referenciados Consumer");
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//Interfaces Funcionales JAVA
		//1.Supplier	
		Stream <String>lista=Stream.generate(() ->  "17239737966").limit(10);
		lista.forEach(cadena->LOG.info(cadena));
		
		//2.Consumer
		List<Integer>listaNumeros=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		listaNumeros.forEach(cadena->{
			LOG.info(""+cadena);
		});
				
		//3.Predicate
		Stream<Integer>listaFinal=listaNumeros.stream().filter(numero->numero>=5);
		listaFinal.forEach(numero->LOG.info("Valor: "+numero));
		
		//4.Function
		Stream<String>listaCambiada=listaNumeros.stream().map(numero->{
			Integer num=10;
			num=numero+num;
			return "N: "+num;
			});
		listaCambiada.forEach(cadena->LOG.info(cadena));
		
		//5.Unary Operator
		Stream<Integer>listaCambiada2=listaNumeros.stream().map(numero->{
			Integer num=10;
			num=numero+num;
			return num;
			});
		listaCambiada2.forEach(cadena->LOG.info(cadena.toString()));*/
		
		//Tarea 16
		//Supplier
		MetodosReferenciados metodos=new MetodosReferenciados();
		IPersonaSupplier<String> supplier=MetodosReferenciados::metodoS;
		LOG.info("Supplier metodo referenciado:");	
		
		//Consumer
		IPersonaConsumer<Integer> consumer=MetodosReferenciados::metodoC;
		LOG.debug("Consumer metodo referenciado:");
		consumer.accept(8);
		
		//Predicate
		IPersonaPredicate<Integer> predicate =MetodosReferenciados::metodoP;
		LOG.debug("Predicate metodo referenciado:"+predicate.evaluar(2));
		
		//Function
		IPersonaFunction<String, Integer> function=MetodosReferenciados::metodoF;
		LOG.debug("Funcion metodo referenciado:"+ function.aplicar(8));
		
		//Unary
		IPersonaUnary<Integer>unary=MetodosReferenciados::metodoU;
		LOG.debug("Unary metodo referenciado:"+unary.aplicar(9));




	
	
		}
	}
