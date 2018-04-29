package com.udea.release1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.release1.entity.Categoria;
import com.udea.release1.repository.CategoriaRepository;


@Service
public class CategoriaService{
	//FALTA IMPLEMENTAR EXCEPCION GENERICA
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAllCategorias(){
		return (List<Categoria>) categoriaRepository.findAll();
	}
	

}
