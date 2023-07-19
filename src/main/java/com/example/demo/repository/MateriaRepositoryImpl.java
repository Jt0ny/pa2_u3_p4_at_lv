package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insetar(Materia materia) {
		this.entityManager.persist(materia);
		
	}
	@Override
	public List<String> seleccionarTodos() {
		TypedQuery<String> myquery = this.entityManager.createQuery("SELECT m.codigo FROM Materia m ", String.class);
		return myquery.getResultList();
	}
	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> myquery = this.entityManager.createQuery("SELECT m FROM Matricula m WHERE m.codigo = :datoCodigo ", Materia.class);
		myquery.setParameter("datoCodigo", codigo);
		return myquery.getSingleResult();
	}

}
