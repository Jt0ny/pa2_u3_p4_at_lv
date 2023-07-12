package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public List<Hotel> buscarInnerJoin() {
		
		return this.hotelRepository.seleccionarInnerJoin();
	}
	@Override
	public List<Hotel> buscarOuterRigthJoin() {
		
		return this.hotelRepository.seleccionarOuterRigthJoin();
	}
	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}
	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		
		return this.hotelRepository.seleccionarHabitacionOuterLeftJoin();
	}
	@Override
	public List<Hotel> buscarOuterFulltJoin() {
		
		return this.hotelRepository.seleccionarOuterFulltJoin();
	}
	@Override
	public List<Hotel> buscarWhereJoin() {
		
		return this.hotelRepository.seleccionarWhereJoin();
	}

}
