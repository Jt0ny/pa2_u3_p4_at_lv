package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelRepository {
	
	public List<Hotel> seleccionarInnerJoin();
	
	

}
