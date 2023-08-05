package com.example.demo.repository;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class CuentaBancariaRepositoryImpl  implements CuentaBancariaRepository{

	private static final Logger LOG= LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(CuentaBancaria ctaBancaria) {
		LOG.info("Hilo repository:"+Thread.currentThread().getName());
		this.entityManager.persist(ctaBancaria);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria seleccionar(String numero) {
		
		TypedQuery<CuentaBancaria> myquery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero", CuentaBancaria.class);
		myquery.setParameter("datoNumero", numero);
		return myquery.getSingleResult();
				
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria ctaBancaria) {
		this.entityManager.merge(ctaBancaria);
		
	}

}
