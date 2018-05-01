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

	public Producto findByCodigo(long id) {
		return productoRepository.findByCodigo(id);
	}
	
	public List<Producto> findByCategoria(long categoria){
		return productoRepository.findByCategoria_Pkcategoria(categoria);
	}

	public List<Producto> findByProductoLike(String producto){
		return productoRepository.findByProductoLike(producto);
	}
}
