package com.pablo.pruebaHibernatePablo;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pablo.pruebaHibernatePablo.Empleado;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_departamento")
	private int id_departamento;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Empleado> empleado;

	
	
	

	public Departamento(int id_departamento, String nombre) {
		super();
		this.id_departamento = id_departamento;
		this.nombre = nombre;
		
	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}
	
	
}
