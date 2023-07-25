package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository propietarioRepository;
	@Autowired
	private IpruebaService ipruebaService;
	
	@Override
	//@Transactional
	//@Transactional(value = TxType.REQUIRED)
	public void guardar(Propietario propietario) {
		System.out.println("service:"+TransactionSynchronizationManager.isActualTransactionActive());
		//this.propietarioRepository.insertar(propietario);
	    //this.ipruebaService.prueba();
		//this.ipruebaService.prueba2();
		//this.ipruebaService.pruebaSupports();
		//this.ipruebaService.pruebaNotSupported();
		//this.ipruebaService.pruebaRequied();
		this.ipruebaService.pruebaRequiedNew();
	}

	@Override
	public Propietario buscar(String cedula) {
		return this.propietarioRepository.seleccionar(cedula);
	}

	
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println("Metodo de prueba");
	}
}
