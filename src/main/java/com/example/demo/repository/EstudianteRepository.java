package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	
	public void insetar(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);

}
