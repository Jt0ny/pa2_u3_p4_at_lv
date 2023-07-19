package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired 
	private  MatriculaRepository matriculaRepository ;
	
	@Override
	public void guardar(String cedula, List<String> codigosM) {
		Estudiante e1= this.estudianteRepository.seleccionarPorCedula(cedula);
		List<Matricula>listaMatriculas=new ArrayList<>();
//		List<Materia> materias=new ArrayList<>();
//		for(int i=0;i<codigosM.size();i++) {
//         materias.add(this.materiaRepository.seleccionarPorCodigo(codigosM.get(i)));
//         materias.se	
//		}
		
		for (String e : codigosM) {
			Matricula mat = new Matricula();
			Materia m = new Materia();
			m.setCodigo(e);
			listaMatriculas.add(mat);
		}
		e1.setMatriculas(listaMatriculas);
		this.matriculaRepository.insertar(listaMatriculas);
		
	}

}
