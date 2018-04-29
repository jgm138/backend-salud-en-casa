package com.udea.release1.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.udea.release1.entity.Categoria;
import com.udea.release1.service.CategoriaService;

//crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones. con crossorigin sin parámetros queda abierto para cualquier maquina
@CrossOrigin
@Controller
@RequestMapping("/api")
public class CategoriaController{
		
	@Autowired
	CategoriaService categoriaService;
	
	public static final Logger logger = LoggerFactory.getLogger(CategoriaController .class);

	// -------------------All Productos---------------------------------------------

	@RequestMapping(value = "/categoria/", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listAllCategorias() {
		try {
		List<Categoria> categorias = categoriaService.findAllCategorias();
		logger.info("api/categoria/ todos las categorias buscados");
		if (categorias.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			//tambièn se puede HttpStatus.NOT_FOUND
		}
			return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
		}catch(Exception ex) {
			logger.error("ocurrió una excepción api/categorias/ todos las categorias buscadas, el ERROR: " + ex.getMessage());
			return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
}