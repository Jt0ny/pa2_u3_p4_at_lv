package com.example.demo.repository;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface CuentaBancariaRepository {
	
	public void insertar(CuentaBancaria ctaBancaria);
	public CuentaBancaria seleccionar(String numero);
	public void actualizar(CuentaBancaria ctaBancaria);

}
