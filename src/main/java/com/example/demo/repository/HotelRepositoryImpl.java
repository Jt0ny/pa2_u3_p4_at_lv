package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
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
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h from Hotel h INNER JOIN h.habitaciones ha", Hotel.class);
		List<Hotel>listaHoteles=myQuery.getResultList();
		for(Hotel h:listaHoteles) {
			h.getHabitaciones().size();
			
		}
		return listaHoteles;
	}

	@Override
	public List<Hotel> seleccionarOuterRigthJoin() {
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h from Hotel h RIGHT JOIN h.habitaciones ha", Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h from Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion>myQuery=this.entityManager.createQuery("SELECT ha from Hotel h LEFT JOIN h.habitaciones ha", Habitacion.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFulltJoin() {
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h from Hotel h FULL JOIN h.habitaciones ha", Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// select h* from hotel h, habitacion ha where h.hot_id=ha.habi_id_hotel
		//SELECT h FROM Hotel h , Habitacion ha WHERE h=ha.hotel
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h , Habitacion ha WHERE h=ha.hotel", Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		TypedQuery<Hotel>myQuery=this.entityManager.createQuery("SELECT h from Hotel h  JOIN FETCH h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Hotel hotel) {
	this.entityManager.persist(hotel);
		
	}

}
