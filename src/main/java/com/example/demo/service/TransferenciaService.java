package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface TransferenciaService {
	
	public void realizarTransferencia(String numOrigen, String numDestino, BigDecimal monto);
	public List<Transferencia> buscarTodos();

}
