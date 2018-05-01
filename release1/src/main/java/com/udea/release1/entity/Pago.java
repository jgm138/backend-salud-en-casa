package com.udea.release1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Pago implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long pkpago;
    
    @NotNull
    @Column(name="valor")
    private float valor;
    
    
    @NotNull
    @Column(name="fecha_hora")
    private LocalDateTime fechaHora;

    
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkcompra")
    private Compra compra;



	public Pago(Long pkpago, @NotNull float valor, @NotNull LocalDateTime fechaHora, Compra compra) {
		super();
		this.pkpago = pkpago;
		this.valor = valor;
		this.fechaHora = fechaHora;
		this.compra = compra;
	}



	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getPkpago() {
		return pkpago;
	}



	public void setPkpago(Long pkpago) {
		this.pkpago = pkpago;
	}



	public float getValor() {
		return valor;
	}



	public void setValor(float valor) {
		this.valor = valor;
	}



	public LocalDateTime getFechaHora() {
		return fechaHora;
	}



	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}



	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	
}
