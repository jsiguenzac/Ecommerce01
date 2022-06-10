package com.cibertec.CL2_Ecommerce_JoelSiguenza.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;

public interface ProductoService {

	public void guardar(Producto p);
			
	public Producto encontrarProducto(Producto p);
	
	public Optional<Producto> obtenerProducto(Long idProducto);
	
	public void eliminar(Producto p);
	 
	public List<Producto> listarProductos();
	
}
