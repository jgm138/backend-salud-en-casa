package com.udea.release1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long pkcategoria;
	
	@NotNull
	private String categoria;
	
	
	@OneToMany(mappedBy="categoria", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(nullable = true)
	//@JsonManagedReference
	private List<Producto> productos;
	
	

	public Categoria() {
		super();
	}



	public Categoria(Long pkcategoria, @NotNull String categoria, List<Producto> productos) {
		super();
		this.pkcategoria = pkcategoria;
		this.categoria = categoria;
		this.productos = productos;
	}



	public Long getPkcategoria() {
		return pkcategoria;
	}



	public void setPkcategoria(Long pkcategoria) {
		this.pkcategoria = pkcategoria;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	

}
