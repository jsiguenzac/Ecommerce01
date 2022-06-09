package com.cibertec.CL2_Ecommerce_JoelSiguenza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;

@Repository
public interface ProductoDAO extends CrudRepository<Producto, Long>{

}
