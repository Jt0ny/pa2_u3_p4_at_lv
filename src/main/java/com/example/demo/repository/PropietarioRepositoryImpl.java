package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PropietarioRepositoryImpl implements PropietarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Propietario propietario) {
		this.entityManager.persist(propietario);
		
	}

	@Override
	public Propietario seleccionar(String cedula) {
		TypedQuery<Propietario> myquery = this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula", Propietario.class);
		myquery.setParameter("datoCedula", cedula);
		return myquery.getSingleResult();
	}
	

}
