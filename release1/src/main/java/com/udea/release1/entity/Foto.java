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
@Table(name = "fotos")
public class Foto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pkfoto")//opcional si se llama igual
	private Long pkfoto;
	
	@NotNull
	@Column(name = "ubicacion")//opcional si se llama igual
	private String ubicacion;
	
	//Desde Jackson 1.6 puedes usar dos anotaciones para resolver el problema de la recursión infinita 
    //sin ignorar a los getters / setters durante la serialización: @JsonManagedReference y @JsonBackReference
    //Para que Jackson funcione bien, uno de los dos lados de la relación no debe ser serializado, 
    //con el fin de evitar el bucle infite que causa su error stackoverflow.
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
    @JoinColumn(name="fkproducto")
    //@JsonBackReference
    private Producto producto;

	public Foto(Long pkfoto, String ubicacion, Producto producto) {
		super();
		this.pkfoto = pkfoto;
		this.ubicacion = ubicacion;
		this.producto = producto;
	}

	public Foto() {
		super();
	}

	public Long getPkfoto() {
		return pkfoto;
	}

	public void setPkfoto(Long pkfoto) {
		this.pkfoto = pkfoto;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Foto [pkfoto=" + pkfoto + ", ubicacion=" + ubicacion + ", producto=" + producto + "]";
	}
    
    
   

	
}
