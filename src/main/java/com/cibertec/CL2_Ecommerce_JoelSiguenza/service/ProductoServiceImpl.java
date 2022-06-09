package com.cibertec.CL2_Ecommerce_JoelSiguenza.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;
import com.cibertec.CL2_Ecommerce_JoelSiguenza.repository.ProductoDAO;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDAO productoDAO;
	
	
	@Override
	public void guardar(Producto p) {
		productoDAO.save(p);
	}

	@Override
	public Producto encontrarProducto(Producto p) {
		return  productoDAO.findById(p.getIdProducto()).orElse(null);
	}

	@Override
	public void eliminar(Producto p) {
		productoDAO.delete(p);
	}

	@Override
	public List<Producto> listarProductos() {
		return  (List<Producto>) productoDAO.findAll();
	}

		
}
