package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.TransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	@Override
	public void realizarTransferencia(String numOrigen, String numDestino, BigDecimal monto) {
		CuentaBancaria ctaBancariaOrigen = this.cuentaBancariaRepository.seleccionar(numOrigen);
		CuentaBancaria ctaBancariaDestino = this.cuentaBancariaRepository.seleccionar(numDestino);

		Transferencia transferencia=new Transferencia();
		transferencia.setCtaBancariaDestino(ctaBancariaDestino);
		transferencia.setCtaBancariaOrigen(ctaBancariaOrigen);
		transferencia.setFecha(LocalDate.now());
		transferencia.setMonto(monto);
		
		BigDecimal saldoOrigen= ctaBancariaOrigen.getSaldo();
		BigDecimal saldoDestino=ctaBancariaDestino.getSaldo();
		
		if(saldoOrigen.compareTo(monto) >= 0) {
			ctaBancariaOrigen.setSaldo(saldoOrigen.subtract(monto));			
			ctaBancariaDestino.setSaldo(saldoDestino.add(monto));

			this.cuentaBancariaRepository.actualizar(ctaBancariaOrigen);
			this.cuentaBancariaRepository.actualizar(ctaBancariaDestino);
			this.transferenciaRepository.insertar(transferencia);

		} else {
			System.out.println("No se pudo hacer la transferencia");
		}

	}

	@Override
	public List<Transferencia> buscarTodos() {
		
		return this.transferenciaRepository.seleccionarTodos();
	}

}