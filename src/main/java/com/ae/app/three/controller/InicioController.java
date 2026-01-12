package com.ae.app.three.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	public InicioController() {
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
