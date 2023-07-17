package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CuentaBancariaRepositoryImpl  implements CuentaBancariaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaBancaria ctaBancaria) {
		this.entityManager.persist(ctaBancaria);
		
	}

	@Override
	public CuentaBancaria seleccionar(String numero) {
		
		TypedQuery<CuentaBancaria> myquery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero", CuentaBancaria.class);
		myquery.setParameter("datoNumero", numero);
		return myquery.getSingleResult();
				
	}

	@Override
	public void actualizar(CuentaBancaria ctaBancaria) {
		this.entityManager.merge(ctaBancaria);
		
	}

}
