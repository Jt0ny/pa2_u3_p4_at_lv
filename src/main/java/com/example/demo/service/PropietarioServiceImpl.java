package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.Propietario;
@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository propietarioRepository;
	@Override
	public void guardar(Propietario propietario) {
		this.propietarioRepository.insertar(propietario);
		
	}

	@Override
	public Propietario buscar(String cedula) {
		
		return this.propietarioRepository.seleccionar(cedula);
	}

}
