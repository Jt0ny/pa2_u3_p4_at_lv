package com.example.demo.funcional;

public class PersonaUnaryImpl implements IPersonaUnary<String>{

	@Override
	public String aplicar(String arg) {
		String cadena="Unary".concat(arg);
		return cadena;
	}

}
