package com.udea.release1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.udea.release1.entity.Producto;

//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
//obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	

	
	Producto findByProducto(String producto);
	
	//@Query("select t from Producto t where t.fkcategoria = :categoria")
	List<Producto> findByCategoria_Pkcategoria(@Param("categoria") Long categoria);
	
	@Query("select t from Producto t where t.id = :id")
	Producto findByCodigo(@Param("id") Long id);
}
