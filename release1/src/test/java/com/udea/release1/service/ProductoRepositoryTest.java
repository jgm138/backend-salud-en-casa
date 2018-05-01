package com.udea.release1.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.udea.release1.entity.Producto;
import com.udea.release1.repository.ProductoRepository;

public class ProductoRepositoryTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		ProductoRepository productoRepo = null;
		List<Producto> productos  = productoRepo.findByCategoria(1);
		System.out.println(productos.size());
		assertTrue("prueba pasada",productos.size()>0);
	}

}
