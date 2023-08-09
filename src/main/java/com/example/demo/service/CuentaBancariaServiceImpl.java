package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.repository.CancionRepository;
import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	
	private static final Logger LOG= LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	@Override
	public void guardar(CuentaBancaria ctaBancaria) {
		LOG.info("Hilo service:"+Thread.currentThread().getName());
		// sumar restar multiplicador ; logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuentaBancariaRepository.insertar(ctaBancaria);
		
	}
	@Override
	public String guardar2(CuentaBancaria ctaBancaria) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuentaBancariaRepository.insertar(ctaBancaria);
		return ctaBancaria.getNumero();
	}

	@Override
	public CuentaBancaria buscar(String numero) {
		
		return this.cuentaBancariaRepository.seleccionar(numero);
	}

	@Override
	public void actualizar(CuentaBancaria ctaBancaria) {
		this.cuentaBancariaRepository.actualizar(ctaBancaria);
		
	}
	@Override
	@Async
	public void agregarAsincrono(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo service:"+Thread.currentThread().getName());
		// sumar restar multiplicador ; logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuentaBancariaRepository.insertar(cuentaBancaria);;
	//	return cuentaBancaria.getNumero();
		
	}
	@Override
	@Async
	//que se completa el retorno en un futuro
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo service:"+Thread.currentThread().getName());
		// sumar restar multiplicador ; logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuentaBancariaRepository.insertar(cuentaBancaria);;
		return CompletableFuture.completedFuture(cuentaBancaria.getNumero());
	}

	

}
