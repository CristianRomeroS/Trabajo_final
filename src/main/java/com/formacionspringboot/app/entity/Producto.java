package com.formacionspringboot.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="clave")
	private long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String descripcion;
	@Column(name="p_unitario")
	private double precioUnitario;
	private int existencias;
	
	
	
	public long getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public double getPrecioUnitario() {
		return precioUnitario;
	}



	public int getExistencias() {
		return existencias;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
