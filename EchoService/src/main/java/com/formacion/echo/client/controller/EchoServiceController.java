package com.formacion.echo.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/echo")
public class EchoServiceController {
	
	@GetMapping("/{id}")
	public String echoService(@PathVariable(required=false) String id) {
		String response = "";
		if (id == null) {
			response = "Echo Service";
		} else {
			response = id;
		}
		return response;		
	}
}
