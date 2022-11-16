package com.pablo.pruebaHibernatePablo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pablo.pruebaHibernatePablo.Departamento;

@Entity
@Table(name="personaje")
public class Empleado implements Serializable{
	
	@Id					// Marca el campo como la clave de la tabla
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_empleado")  // Opcional si coinciden atributo y columna. 
	private int id_personaje; // Indica la columna de la tabla que corresponde con este atributo
	
	@Column(name="nombre")
	private String nombre;
	

	@ManyToOne
	@JoinColumn(name="id_departamento",referencedColumnName="id_departamento")
	private Departamento dep;


	public Empleado(int id_personaje, String nombre, Departamento dep) {
		super();
		this.id_personaje = id_personaje;
		this.nombre = nombre;
		this.dep = dep;
	}


	public Empleado() {
		super();
	}


	public int getId_personaje() {
		return id_personaje;
	}


	public void setId_personaje(int id_personaje) {
		this.id_personaje = id_personaje;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Departamento getDep() {
		return dep;
	}


	public void setDep(Departamento dep) {
		this.dep = dep;
	}
	
	
	
}
