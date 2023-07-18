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
@Table( name= "provincia")
public class Provincia {
	
	@GeneratedValue(generator ="seq_provincia",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_provincia",sequenceName = "seq_provincia",allocationSize = 1)
	@Id
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_nombre")
	private String nombre;
	
	@Column(name = "prov_ubicacion")
	private String ubicacion;
	 
	@Column(name = "prov_alcalde")
	private String alcalde;
	
	@OneToMany(mappedBy = "provincia")
	private List<Estudiante>estudiantes;

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getAlcalde() {
		return alcalde;
	}

	public void setAlcalde(String alcalde) {
		this.alcalde = alcalde;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	

}
