package com.cibertec.CL2_Ecommerce_JoelSiguenza.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;
import com.cibertec.CL2_Ecommerce_JoelSiguenza.service.ProductoService;

@Controller
//@Slf4j
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("")
	public String listadoPro(Model model) {
		
		model.addAttribute("productos", productoService.listarProductos());
		return "productos/listarProductos";
	}
	
	
	@GetMapping("/nuevo")
	public String nuevoPro(Producto p, Model model) {
		model.addAttribute("productos" , p);	
		return "productos/crearProducto";
	}
	
	@PostMapping("/grabar")
	public String guardar(Producto p) {
				
		productoService.guardar(p);
		return "redirect:/productos";
	}
	
	@GetMapping("/editar/{idProducto}")
	public String editar(Producto p , Model model){
       p = productoService.encontrarProducto(p); 	       
       model.addAttribute("productos" , p);	       
       return "productos/crearProducto";	       
	}
	
	
	@GetMapping("/eliminar/{idProducto}")
	public String eliminar(Producto p){	    
	    productoService.eliminar(p);
	    return "redirect:/productos";	    
	}
	
	
	
}
