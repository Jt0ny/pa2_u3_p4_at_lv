package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
	
	@GeneratedValue(generator ="seq_hotel",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_hotel",sequenceName = "seq_hotel",allocationSize = 1)// el allocationSize de coincidir con el valor que pusimos en el incremento
	@Id
	@Column(name = "hot_id")
	private Integer id;

	@Column(name = "hot_nombre")
	private String nombre;

	@Column(name = "hot_direccion")
	private String direccion;

	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL,fetch = FetchType.LAZY) //>>>>>>>>>  un hotel tiene varias habitaciones 
	private List <Habitacion> habitaciones;
	
	/*@OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY) //>>>>>>>>>  un hotel tiene varias habitaciones 
	private List <Habitacion> habitacionesfetch;*/



	/*@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion +  "]";
	}*/


	/*public List<Habitacion> getHabitacionesfetch() {
		return habitacionesfetch;
	}


	public void setHabitacionesfetch(List<Habitacion> habitacionesfetch) {
		this.habitacionesfetch = habitacionesfetch;
	}*/


	//set y get 
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}


	

}
