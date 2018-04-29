package com.udea.release1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udea.release1.entity.Producto;

import com.udea.release1.repository.ProductoRepository;

@Service
public class ProductoService{
	//FALTA IMPLEMENTAR EXCEPCION GENERICA
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> findAllProductos(){
		return (List<Producto>) productoRepository.findAll();
	}
	

}
