package com.cibertec.CL2_Ecommerce_JoelSiguenza.service;

import java.util.List;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;

public interface ProductoService {

	public void guardar(Producto p);
	
	public Producto encontrarProducto(Producto p);
	 
	public void eliminar(Producto p);
	 
	public List<Producto> listarProductos();
	
	
}
