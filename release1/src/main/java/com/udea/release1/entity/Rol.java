package com.udea.release1.entity;

import java.io.Serializable;
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
	@Table(name = "roles")
	public class Rol implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "pkrol")//opcional si se llama igual
		private Long pkrol;
		
		@NotNull
		@Column(name="rol") //opcional si se llama igual
		private String rol;
		
		
		@OneToMany(mappedBy="rol", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
		@Column(nullable = true)
		//@JsonManagedReference
		private List<Usuario> usuarios;
		
		

		public Rol() {
			super();
		}



		public Long getPkrol() {
			return pkrol;
		}



		public void setPkrol(Long pkrol) {
			this.pkrol = pkrol;
		}



		public String getRol() {
			return rol;
		}



		public void setRol(String rol) {
			this.rol = rol;
		}
		
		

}
