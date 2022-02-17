package com.formacionspringboot.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="n_cliente")
	private long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private String sexo;
	@Column(nullable=false)
	private int telefono;
	
	
	
	public long getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public String getSexo() {
		return sexo;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
