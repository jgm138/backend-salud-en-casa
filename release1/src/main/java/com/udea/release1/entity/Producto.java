package com.udea.release1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
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

}