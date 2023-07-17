package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CancionRepository;
import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	@Override
	public void guardar(CuentaBancaria ctaBancaria) {
		this.cuentaBancariaRepository.insertar(ctaBancaria);
		
	}

	@Override
	public CuentaBancaria buscar(String numero) {
		
		return this.cuentaBancariaRepository.seleccionar(numero);
	}

	@Override
	public void actualizar(CuentaBancaria ctaBancaria) {
		this.cuentaBancariaRepository.actualizar(ctaBancaria);
		
	}

}
