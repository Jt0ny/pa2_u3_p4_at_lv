package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name= "semestre")
public class Semestre {

	@GeneratedValue(generator ="seq_semestre",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_semestre",sequenceName = "seq_semestre",allocationSize = 1)
	@Id
	@Column(name = "smes_id")
	private Integer id;
	
	@Column(name = "smes_num_semestre")
	private String nSemestre;
	
	@Column(name = "smes_año")
	private String año;
	
	@Column(name = "smes_modalidad")
	private String modalidad;
	
	@OneToMany(mappedBy = "semestre")
	private List<Materia>materias;

	
	//set y get 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getnSemestre() {
		return nSemestre;
	}

	public void setnSemestre(String nSemestre) {
		this.nSemestre = nSemestre;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	
	
}
