package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class TransferenciaRepositoryImpl implements TransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Transferencia transferencia) {
		this.entityManager.persist(transferencia);
		throw new RuntimeException();
		
	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		TypedQuery<Transferencia> myquery = this.entityManager.createQuery("SELECT t FROM Transferencia t", Transferencia.class);
		return myquery.getResultList();
	}

}
