package com.example.demo.funcional;

public class PersonaFunctionImpl implements IPersonaFunction<String,Integer > {

	@Override
	public String aplicar(Integer arg) {
		String valor = "Numero String ".concat(arg.toString());
		return valor;
	}

}
