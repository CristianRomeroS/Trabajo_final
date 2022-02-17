package com.formacionspringboot.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ventas")
public class Venta implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="folio")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_cliente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clave")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Producto producto;
	
	@Column(nullable=false)
	private int cantidad;
	@Column(nullable=false)
	private double subtotal;
	@Column(nullable=false)
	private double iva;
	@Column(nullable=false)
	private double total;
	
	
	public long getId() {
		return id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Producto getProducto() {
		return producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public double getIva() {
		return iva;
	}


	public double getTotal() {
		return total;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
