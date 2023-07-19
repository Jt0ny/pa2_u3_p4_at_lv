package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ArtistaService;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MatriculaService;
import com.example.demo.service.PropietarioService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	@Autowired
	private MatriculaService matriculaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		Estudiante e1= new Estudiante();
		e1.setNombre("Luis");
		e1.setApellido("v");
		e1.setCedula("12345");
		
		List<Estudiante> estu = new ArrayList<>();
		estu.add(e1);
		
		Provincia pro= new Provincia();
		pro.setAlcalde("Juan");
		pro.setNombre("Orrellana");
		pro.setEstudiantes(estu);
		 
		e1.setProvincia(pro);
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		 Semestre sm= new Semestre();
		 sm.setAño("2023");
		 sm.setModalidad("Presencial");
		 sm.setnSemestre("8");
		 
		 Materia m1= new Materia();
		 m1.setCodigo("01");
		 m1.setNombre("SA");
		 m1.setProfesor("pro");
		 m1.setSemestre(sm);
		 
		 Materia m2= new Materia();
		 m2.setCodigo("02");
		 m2.setNombre("Ag");
		 m2.setProfesor("prswqo");
		 m2.setSemestre(sm);
		 
		 List< Materia> materias= new ArrayList<>();
		 materias.add(m1);
		 materias.add(m2);

		 sm.setMaterias(materias);
		 
		 //<<<<<<<<<<
		 Matricula matri =new Matricula();
		 matri.setCosto(new BigDecimal(45));
		 matri.setNumero("5");
		 matri.setEstudiante(e1);
		 matri.setMateria(m1);
		 
		 Matricula matri1 =new Matricula();
		 matri1.setCosto(new BigDecimal(45));
		 matri1.setNumero("6");
		 matri1.setEstudiante(e1);
		 matri1.setMateria(m2);
		 
		 List<Matricula> matriculas= new ArrayList<>();
		 matriculas.add(matri1);
		 matriculas.add(matri);
		 
		 e1.setMatriculas(matriculas);
		 m1.setMatriculas(matriculas);
		 m2.setMatriculas(matriculas);
		 
		 List<String> codigos = new ArrayList<>();
		 codigos.add(m1.getCodigo());
		 codigos.add(m2.getCodigo());
		 
		 this.matriculaService.guardar(e1.getCedula(), codigos);
		 
		 
		 
		 
		 
		 
		
		
		
		
		
	}

}
