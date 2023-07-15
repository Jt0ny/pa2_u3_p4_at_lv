package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CancionRepository;
import com.example.demo.repository.modelo.Cancion;

@Service
public class CancionServiceImpl implements CancionService{

	@Autowired
	private CancionRepository cancionRepository;
	
	@Override
	public void guardar(Cancion cancion) {
		this.cancionRepository.insertar(cancion);
		
	}
	

}
