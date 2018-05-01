package com.udea.release1.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.udea.release1.entity.Producto;
import com.udea.release1.exception.CustomErrorType;
import com.udea.release1.exception.ExcepcionGenerica;
import com.udea.release1.service.ProductoService;

//crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones. con crossorigin sin parámetros queda abierto para cualquier maquina
@CrossOrigin
@Controller
@RequestMapping("/api")
public class ProductoController{
		
	@Autowired
	ProductoService productoService;
	
	public static final Logger logger = LoggerFactory.getLogger(ProductoController .class);

	// -------------------All Productos---------------------------------------------

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/producto/", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listAllProductos() {
		try {
		List<Producto> productos = productoService.findAllProductos();
		logger.info("api/producto/ todos los productos buscados");
		if (productos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			//tambièn se puede HttpStatus.NOT_FOUND
		}
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		}catch(Exception ex) {
			logger.error("ocurrió una excepción api/producto/ todos los productos buscados, el ERROR: " + ex.getMessage());
			return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}

	// -------------------Producto por id------------------------------------------

	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProducto(@PathVariable("id") long id) {
		logger.info("Buscando Producto con id {}", id);
		try {			
			Producto producto = productoService.findByCodigo(id);
			if (producto == null) {
				logger.error("Producto con id {} not existe.", id);
				return new ResponseEntity(new CustomErrorType("Producto no existe"), HttpStatus.NOT_FOUND);
				/*return new ResponseEntity(new ExcepcionGenerica("error consultando", "Producto con id: " + id 
						+ " no existe"),"202", HttpStatus.NOT_FOUND);*/
			}
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}catch(Exception ex) {
			logger.error("ocurrió una excepción api/producto/{id}, el ERROR: " + ex.getMessage());
			return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// -------------------Buscar Productos por categoria------------------------------------------

		@RequestMapping(value = "/producto/categoria/{categoria}", method = RequestMethod.GET)
		public ResponseEntity<?> getProductosByCategoria(@PathVariable("categoria") long categoria) {
			logger.info("Buscando Productos de categoria con id {}", categoria);
			try {
			List<Producto> productos = productoService.findByCategoria(categoria);
			logger.info("api/producto/categoria/{categoria}");
			if (productos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				//tambièn se puede HttpStatus.NOT_FOUND
			}
				return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
			}catch(Exception ex) {
				logger.error("ocurrió una excepción api/producto/categoria/{categoria}, el ERROR: " + ex.getMessage());
				return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
			}
		}

	/*
	// -------------------Create a Producto-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
			user.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Updating User with id {}", id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		User user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		logger.info("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	*/

}
