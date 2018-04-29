package com.udea.release1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pkcategoria")//opcional si se llama igual
	private Long pkcarrito;
	
	
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}

}
