package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface MateriaRepository {
	
	public void insetar(Materia materia);
	
	public List<String> seleccionarTodos();

}
