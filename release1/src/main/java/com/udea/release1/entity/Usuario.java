package com.udea.release1.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "usuarios")
public class Usuario implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pkusuario")
    private Long pkusuario;
    
    @NotNull
    @Column(name="email", unique=true)
    private String email;
    
    @NotNull
    @Column(name="password")
    private String password;
    
    @Null
    @Column(name="nombres")
    private String nombres;
    
    @Null
    @Column(name="apellidos")
    private String apellidos;
    
    @Null
    @Column(name="genero")
    private byte genero;
    
    @Null
    @Column(name="fechanacimiento")
    private LocalDate fechaNacimiento;
        
    @NotNull
    @Column(name="primeravez")
    private boolean primerEntrada;
    
       
    
    //Desde Jackson 1.6 puedes usar dos anotaciones para resolver el problema de la recursión infinita 
    //sin ignorar a los getters / setters durante la serialización: @JsonManagedReference y @JsonBackReference
    //Para que Jackson funcione bien, uno de los dos lados de la relación no debe ser serializado, 
    //con el fin de evitar el bucle infite que causa su error stackoverflow.
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)//EAGER
    @JoinColumn(name="fkrol")
    //@JsonBackReference
    private Rol rol;
    
    
    @OneToMany(mappedBy="usuario", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(nullable = true)
	//@JsonManagedReference
	private List<Carrito> carritos;


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getPkusuario() {
		return pkusuario;
	}


	public void setPkusuario(Long pkusuario) {
		this.pkusuario = pkusuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public byte getGenero() {
		return genero;
	}


	public void setGenero(byte genero) {
		this.genero = genero;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public boolean isPrimerEntrada() {
		return primerEntrada;
	}


	public void setPrimerEntrada(boolean primerEntrada) {
		this.primerEntrada = primerEntrada;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
    
    
    
}
