package com.udea.release1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "compras")
public class Compra implements Serializable{

	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "pkcompra")
	    private Long pkcompra;
	    
	    @NotNull
	    @Column(name = "fechahora")
	    private LocalDateTime fechaHora;
	    
	    @NotNull
	    @Column(name = "direccion")
	    private String direccion;

	    @Null
	    @Column(name = "descuento")
	    private float descuento;
	    
	    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
	    @JoinColumn(name="fkusuario")
	    //@JsonBackReference
	    private Usuario usuario;
	    
	    @OneToMany(mappedBy="compra", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
		@Column(nullable = true)
		//@JsonManagedReference
		private List<DetalleCompra> detallesCompra;
	    
	    

		public Compra(Long pkcompra, @NotNull LocalDateTime fechaHora, @NotNull String direccion, @Null float descuento,
				Usuario usuario) {
			super();
			this.pkcompra = pkcompra;
			this.fechaHora = fechaHora;
			this.direccion = direccion;
			this.descuento = descuento;
			this.usuario = usuario;
		}

		public Compra() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getPkcompra() {
			return pkcompra;
		}

		public void setPkcompra(Long pkcompra) {
			this.pkcompra = pkcompra;
		}

		public LocalDateTime getFechaHora() {
			return fechaHora;
		}

		public void setFechaHora(LocalDateTime fechaHora) {
			this.fechaHora = fechaHora;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public float getDescuento() {
			return descuento;
		}

		public void setDescuento(float descuento) {
			this.descuento = descuento;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public List<DetalleCompra> getDetallesCompra() {
			return detallesCompra;
		}

		public void setDetallesCompra(List<DetalleCompra> detallesCompra) {
			this.detallesCompra = detallesCompra;
		}

		
	    
	    
	    
}
