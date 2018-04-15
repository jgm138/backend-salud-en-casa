package com.udea.release1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long pkproducto;
    
    @NotNull
    private String producto;
    
    @NotNull
    private String descripcion;

    @NotNull
    private String caracteristicas;
    
    @NotNull
    private String volumen;
    
    @NotNull
    private byte appmovil;
    
    @NotNull
    private float precio;
    /*
    @ManyToOne
    @JoinColumn(name="fkcategoria")
    private Categoria categoria;
    */

	public Long getPkproducto() {
		return pkproducto;
	}
	

	public Producto() {
		
	}


	public Producto(Long pkproducto, @NotNull String producto, @NotNull String descripcion, @NotNull String caracteristicas,
			@NotNull String volumen, @NotNull byte appmovil, @NotNull float precio) {
		super();
		this.pkproducto = pkproducto;
		this.producto = producto;
		this.descripcion = descripcion;
		this.caracteristicas = caracteristicas;
		this.volumen = volumen;
		this.appmovil = appmovil;
		this.precio = precio;
	}

	public void setPkproducto(Long pkproducto) {
		this.pkproducto = pkproducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public byte getAppmovil() {
		return appmovil;
	}

	public void setAppmovil(byte appmovil) {
		this.appmovil = appmovil;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
    

}