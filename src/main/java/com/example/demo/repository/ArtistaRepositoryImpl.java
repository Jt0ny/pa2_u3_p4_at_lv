package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Artista;
import com.example.demo.repository.modelo.Cancion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ArtistaRepositoryImpl implements ArtistaRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Artista artista) {
		this.entityManager.persist(artista);
		
	}

	//INNER JOIN
	@Override
	public List<Artista> seleccionarArtistasInnerJoin() {
		
		TypedQuery<Artista>myQuery=this.entityManager.createQuery("SELECT a from Artista a INNER JOIN a.canciones ca", Artista.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cancion> seleccionarCancionesInnerJoin() {
		TypedQuery<Cancion>myQuery=this.entityManager.createQuery("SELECT ca from Artista a INNER JOIN a.canciones ca", Cancion.class);
		return myQuery.getResultList();
	}

	//OUTER RIGTH
	@Override
	public List<Artista> seleccionarArtistasOuterRigthJoin() {
		TypedQuery<Artista>myQuery=this.entityManager.createQuery("SELECT a from Artista a RIGHT JOIN  a.canciones ca", Artista.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cancion> seleccionarCancionesOuterRigthJoin() {
		TypedQuery<Cancion>myQuery=this.entityManager.createQuery("SELECT ca from Artista a RIGHT JOIN  a.canciones ca", Cancion.class);
		return myQuery.getResultList();
	}

	//OUTER LEFT
	@Override
	public List<Artista> seleccionarArtistasOuterLeftJoin() {
		TypedQuery<Artista>myQuery=this.entityManager.createQuery("SELECT a from Artista a LEFT JOIN  a.canciones ca", Artista.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cancion> seleccionarCancionesOuterLeftJoin() {
		TypedQuery<Cancion>myQuery=this.entityManager.createQuery("SELECT ca from Artista a LEFT JOIN  a.canciones ca", Cancion.class);
		return myQuery.getResultList();
	}
 
	//OUTER FULL
	@Override
	public List<Artista> seleccionarArtistasOuterFulltJoin() {
		TypedQuery<Artista>myQuery=this.entityManager.createQuery("SELECT a from Artista a FULL JOIN  a.canciones ca", Artista.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cancion> seleccionarCancionesOuterFulltJoin() {
		TypedQuery<Cancion>myQuery=this.entityManager.createQuery("SELECT ca from Artista a FULL JOIN a.canciones ca", Cancion.class);
		return myQuery.getResultList();
	}

	//WHERE
	@Override
	public List<Artista> seleccionarArtistasWhereJoin() {
		TypedQuery<Artista>myQuery=this.entityManager.createQuery("SELECT a FROM Artista a , Cancion ca WHERE a=ca.artista", Artista.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cancion> seleccionarCancionesWhereJoin() {
		TypedQuery<Cancion>myQuery=this.entityManager.createQuery("SELECT ca FROM Artista a , Cancion ca WHERE a=ca.artista", Cancion.class);
		return myQuery.getResultList();
	}



}
