package com.udea.release1.controller;

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

import com.udea.release1.entity.Categoria;
import com.udea.release1.entity.Foto;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long pkusuario;
    
    @NotNull
    private String email;
        
    @NotNull
    private byte primeravez;
    
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
    
}
