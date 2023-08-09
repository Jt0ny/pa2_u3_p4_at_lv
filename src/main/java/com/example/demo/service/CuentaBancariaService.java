package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface CuentaBancariaService {

	public void guardar(CuentaBancaria ctaBancaria);
	public String guardar2(CuentaBancaria ctaBancaria);
	public CuentaBancaria buscar(String numero);
	public void actualizar(CuentaBancaria ctaBancaria);

	public void agregarAsincrono(CuentaBancaria cuentaBancaria);
	
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria cuentaBancaria);
	
	
}
