package com.formacion.cliente.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.cliente.entities.Cliente;
import com.formacion.cliente.services.IClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clientesService;
	
	@PostMapping(produces = "application/json")
	@ResponseBody
	@Operation(
			summary = "Anade cliente",
			description = "Anade el cliente que se pasa como parámetro en el cuerpo de "+
						  "la llamada",
			responses = {
					@ApiResponse(description = "La llamada se realizó correctamente", 
							responseCode = "201", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class))), 
					@ApiResponse(description = "Recurso no encontrado", 
							responseCode = "404", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class))),
					@ApiResponse(description = "Error interno del servidor", 
							responseCode = "500", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class)))
			})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> addCliente(
			@Parameter(
					description = "Cliente que se quiere anadir",
					required = true,
					example = "Cliente(1, 'Juan', 'Gómez', '12345678A', 'juango@gmail.com', '123456789', 'Calle Alta 52')")
			@RequestBody Cliente c,
			HttpServletResponse response) {
		Cliente result = this.clientesService.addCliente(c);
		ResponseEntity<Cliente> respuesta;
		if (result == null) {
			respuesta = new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		} else {
			respuesta = new ResponseEntity<Cliente>(result, HttpStatus.OK);
		}
		return respuesta;
	}
	
	@DeleteMapping(path = "/eliminaCliente/{idCliente}", produces = "application/json")
	@ResponseBody
	@Operation(
			summary = "Elimina cliente",
			description = "Elimina el cliente cuyo id se pasa como parámetro",
			responses = {
					@ApiResponse(description = "La llamada se realizó correctamente", 
							responseCode = "200", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class))), 
					@ApiResponse(description = "Recurso no encontrado", 
							responseCode = "404", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class))),
					@ApiResponse(description = "Error interno del servidor", 
							responseCode = "500", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class)))
			})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cliente> deleteCliente(
			@Parameter(
					description = "Id del cliente que se quiere eliminar",
					required = true,
					example = "42")
			@PathVariable("idCliente") int idCliente,
			HttpServletResponse response) {
		Cliente result = this.clientesService.deleteCliente(idCliente);
		ResponseEntity<Cliente> respuesta;
		if (result == null) {
			respuesta = new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		} else {
			respuesta = new ResponseEntity<Cliente>(result, HttpStatus.OK);
		}
		return respuesta;
	}
	
	@PutMapping(path="/actualizaCliente", produces = "application/json")
	@ResponseBody
	@Operation(
			summary = "Actualiza cliente",
			description = "Actualiza el cliente con los datos del cliente proporcionados "+
						   "como parámetros",
			responses = {
					@ApiResponse(description = "La llamada se realizó correctamente", 
							responseCode = "200", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class))), 
					@ApiResponse(description = "Recurso no encontrado", 
							responseCode = "404", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class))),
					@ApiResponse(description = "Error interno del servidor", 
							responseCode = "500", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class)))
			})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cliente> updateCliente(
			@Parameter(
					description = "Cliente que se quiere modificar con sus nuevos datos",
					required = true,
					example = "Cliente(1, 'Juan', 'Gómez', '12345678A', 'juango@gmail.com', '123456789', 'Calle Alta 52')")
			@RequestBody Cliente c,
			HttpServletResponse response) {
		Cliente result = this.clientesService.updateCliente(c);
		ResponseEntity<Cliente> respuesta;
		if (result == null) {
			respuesta = new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		} else {
			respuesta = new ResponseEntity<Cliente>(result, HttpStatus.OK);
		}
		return respuesta;
	}
	
	@GetMapping(path = "/{idCliente}", produces = "application/json")
	@ResponseBody
	@Operation(
			summary = "Consulta clientes",
			description = "Muestra todos los clientes que haya en la base de datos.",
			responses = {
					@ApiResponse(description = "La llamada se realizó correctamente", 
							responseCode = "200", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class))), 
					@ApiResponse(description = "Recurso no encontrado", 
							responseCode = "404", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class))),
					@ApiResponse(description = "Error interno del servidor", 
							responseCode = "500", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class)))
			})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cliente> getCliente(
			@Parameter(
					description = "Id del cliente que se quiere consultar",
					required = true,
					example = "42")
			@PathVariable(value = "idCliente") int idCliente,
			HttpServletResponse response) {
		Cliente result = this.clientesService.getCliente(idCliente);
		ResponseEntity<Cliente> respuesta;
		if (result == null) {
			respuesta = new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		} else {
			respuesta = new ResponseEntity<Cliente>(result, HttpStatus.OK);
		}
		return respuesta;
	}
	
	@GetMapping(produces = "application/json")
	@ResponseBody
	@Operation(
			summary = "Consulta clientes",
			description = "Muestra todos los clientes que haya en la base de datos.",
			responses = {
					@ApiResponse(description = "La llamada se realizó correctamente", 
							responseCode = "200", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class))), 
					@ApiResponse(description = "Recurso no encontrado", 
							responseCode = "404", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class))),
					@ApiResponse(description = "Error interno del servidor", 
							responseCode = "500", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = String.class)))
			})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Cliente>> getClientes(HttpServletResponse response) {
		List<Cliente> result = this.clientesService.getClientes();
		ResponseEntity<List<Cliente>> respuesta;
		if (result == null) {
			respuesta = new ResponseEntity<List<Cliente>>(HttpStatus.BAD_REQUEST);
		} else {
			respuesta = new ResponseEntity<List<Cliente>>(result, HttpStatus.OK);
		}
		return respuesta;
	}
}
