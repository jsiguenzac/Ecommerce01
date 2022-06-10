package com.cibertec.CL2_Ecommerce_JoelSiguenza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibertec.CL2_Ecommerce_JoelSiguenza.service.ProductoService;

@Controller
//@RequestMapping("")
public class HomeController {

	@Autowired
	private ProductoService productoService;	
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("productos", productoService.listarProductos());
		return "home";
	}
	
	
	
	
}
