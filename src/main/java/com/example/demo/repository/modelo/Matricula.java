package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name= "matricula")
public class Matricula {
	
	@GeneratedValue(generator ="seq_matricula",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_matricula",sequenceName = "seq_matricula",allocationSize = 1)
	@Id
	@Column(name = "matr_id")
	private Integer id;
	
	@Column(name = "matr_numero")
	private String numero;
	
	@Column(name = "matr_costo")
	private BigDecimal costo;
	
	@Column(name = "matr_fecha")
	private LocalDate fecha;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matr_id_estu")
	private Estudiante estudiante;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mate_id_estu")
	private Materia materia;

	
	
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", numero=" + numero + ", costo=" + costo + ", fecha=" + fecha + ", estudiante="
				+ estudiante + ", materia=" + materia + "]";
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	

}
