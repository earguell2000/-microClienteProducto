package com.formacion.echo.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoServiceController {
	
	@RequestMapping(value="/")
	public String echoService() {
		return "Echo Service";
	}
	
	@GetMapping("/{id}")
	public String echoService(@PathVariable String id) {
		return id;		
	}
}
