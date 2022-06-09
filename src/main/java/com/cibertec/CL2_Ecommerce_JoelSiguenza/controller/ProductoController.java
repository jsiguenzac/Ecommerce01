package com.cibertec.CL2_Ecommerce_JoelSiguenza.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String guardar(@RequestParam(name = "file", required = true) MultipartFile imagen, Producto p){
		
		if (!imagen.isEmpty()) {
			String ruta = "D://imagesCL2";
			
			try {
				byte [] byteImg = imagen.getBytes();
				Path rutaAbsoluta= Paths.get(ruta + "//" + imagen.getOriginalFilename());
				
				Files.write(rutaAbsoluta, byteImg);
				
				p.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
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
	public String eliminar(Producto p, @PathVariable Long idProducto){	  
					
	    productoService.eliminar(p);
	    return "redirect:/productos";	    
	}
	
	/////////DETALLE
	@GetMapping("/detalle/{idProducto}")
	public String detallePro(@PathVariable Long idProducto) {
		
		return "productos/detalleProducto";
	}
	
	
	
	
	
}
