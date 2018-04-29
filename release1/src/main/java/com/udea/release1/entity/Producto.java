package com.udea.release1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    
    //Desde Jackson 1.6 puedes usar dos anotaciones para resolver el problema de la recursión infinita 
    //sin ignorar a los getters / setters durante la serialización: @JsonManagedReference y @JsonBackReference
    //Para que Jackson funcione bien, uno de los dos lados de la relación no debe ser serializado, 
    //con el fin de evitar el bucle infite que causa su error stackoverflow.
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
    @JoinColumn(name="fkcategoria")
    //@JsonBackReference
    private Categoria categoria;
    
    
    @OneToMany(mappedBy="producto", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(nullable = true)
	//@JsonManagedReference
	private List<Foto> fotos;
    

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


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	public List<Foto> getFotos() {
		return fotos;
	}


	public Producto(Long pkproducto, @NotNull String producto, @NotNull String descripcion,
			@NotNull String caracteristicas, @NotNull String volumen, @NotNull byte appmovil, @NotNull float precio,
			Categoria categoria) {
		super();
		this.pkproducto = pkproducto;
		this.producto = producto;
		this.descripcion = descripcion;
		this.caracteristicas = caracteristicas;
		this.volumen = volumen;
		this.appmovil = appmovil;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	//NO LE COLOCO EL GETTER Y SETTER DE LA RELACION PARA QUE NO HAYA UN JSON RECURSIVO INFINITO
    

}