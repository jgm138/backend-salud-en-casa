package com.udea.release1.entity;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="detalle_compra")
public class DetalleCompra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pk_detalle_compra")
    private Long pkDetalleCompra;
	
	@NotNull
	@Column(name="cantidad")
	private int cantidad;
	
	@NotNull
	@Column(name="valor_unidad")
	private float valorUnidad;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
	@JoinColumn(name="fkcompra")
	//@JsonBackReference	    
	private Compra compra;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
	@JoinColumn(name="fkproducto")
	//@JsonBackReference
	private Producto producto;

	

	public DetalleCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPkDetalleCompra() {
		return pkDetalleCompra;
	}

	public void setPkDetalleCompra(Long pkDetalleCompra) {
		this.pkDetalleCompra = pkDetalleCompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(float valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	

}
