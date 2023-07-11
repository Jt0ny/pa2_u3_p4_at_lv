package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository {

	@PersistenceContext
	private EntityManager entityManager ;
	
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// /select * from hotel h inner join habitacion ha on h.hot_id=ha.habi_id_hotel 
		//SELECT h from hotel h JOIN h.habitaciones ha 
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h from Hotel h JOIN h.habitaciones ha", Hotel.class);
		
		return myQuery.getResultList();
	}

}
