package com.udea.release1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udea.release1.entity.Categoria;

//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
//obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
		Categoria findByCategoria(String categoria);
}
