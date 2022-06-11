package com.cibertec.CL2_Ecommerce_JoelSiguenza.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;
import com.cibertec.CL2_Ecommerce_JoelSiguenza.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping("/{idProducto}")
	public ResponseEntity<?> read(@PathVariable Long idProducto){
		
		Optional<Producto> pro = productoService.obtenerProducto(idProducto);
			
		if (!pro.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pro);
	}
	
	
	
}
