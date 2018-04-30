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
@Table(name = "carrito")
public class Carrito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pkcarrito")//opcional si se llama igual
	private Long pkcarrito;
	
	@NotNull
    @Column(name="cantidad")
    private int cantidad;
	
	//Desde Jackson 1.6 puedes usar dos anotaciones para resolver el problema de la recursión infinita 
    //sin ignorar a los getters / setters durante la serialización: @JsonManagedReference y @JsonBackReference
    //Para que Jackson funcione bien, uno de los dos lados de la relación no debe ser serializado, 
    //con el fin de evitar el bucle infite que causa su error stackoverflow.
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
    @JoinColumn(name="fkusuario")
    //@JsonBackReference
    private Usuario usuario;
    
  //Desde Jackson 1.6 puedes usar dos anotaciones para resolver el problema de la recursión infinita 
    //sin ignorar a los getters / setters durante la serialización: @JsonManagedReference y @JsonBackReference
    //Para que Jackson funcione bien, uno de los dos lados de la relación no debe ser serializado, 
    //con el fin de evitar el bucle infite que causa su error stackoverflow.
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
    @JoinColumn(name="fkproducto")
    //@JsonBackReference
    private Producto producto;
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}

	public Long getPkcarrito() {
		return pkcarrito;
	}

	public void setPkcarrito(Long pkcarrito) {
		this.pkcarrito = pkcarrito;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
