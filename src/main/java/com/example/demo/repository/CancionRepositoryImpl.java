package com.example.demo.repository;

import org.springframework.stereotype.Repository;


import com.example.demo.repository.modelo.Cancion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CancionRepositoryImpl implements CancionRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cancion cancion) {
		this.entityManager.persist(cancion);
	}

}
