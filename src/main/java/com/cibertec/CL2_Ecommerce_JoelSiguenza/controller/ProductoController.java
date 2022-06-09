package com.cibertec.CL2_Ecommerce_JoelSiguenza.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.model.Producto;
import com.cibertec.CL2_Ecommerce_JoelSiguenza.service.FileImagenService;
import com.cibertec.CL2_Ecommerce_JoelSiguenza.service.ProductoService;

@Controller
//@Slf4j
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	private FileImagenService imagenService;

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
	public String guardar(Producto p, @RequestParam("imagen") MultipartFile file) throws IOException {
		
		//imagen
		if (p.getIdProducto()==null) {
			String nombreImg = imagenService.guardarImg(file);
			p.setImagen(nombreImg);
		} else {
			if (file.isEmpty()) {
				Producto pro = new Producto();
				pro = productoService.encontrarProducto(p);
				p.setImagen(pro.getImagen());
			} else {
				String nombreImg = imagenService.guardarImg(file);
				p.setImagen(nombreImg);
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
	public String eliminar(Producto p){	    
	    productoService.eliminar(p);
	    return "redirect:/productos";	    
	}
	
	
	
}
