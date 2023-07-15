package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	
	public void guardar(Hotel hotel);
	
	public List<Hotel> buscarInnerJoin();
	
	public List<Hotel> buscarOuterRigthJoin();
	
	public List<Hotel> buscarOuterLeftJoin();
	
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	
	public List<Hotel>buscarOuterFulltJoin();
	
	public List<Hotel> buscarWhereJoin();
	
	public List<Hotel>buscarJoinFetch();
}
