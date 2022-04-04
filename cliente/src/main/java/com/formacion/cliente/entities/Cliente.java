package com.formacion.cliente.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	//Atributos
	@Id
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String numTelefono;
	private String direccion;
	
	public Cliente() {
		
	}

	public Cliente(int id, String nombre, String apellidos, String dni, String email, String numTelefono, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.numTelefono = numTelefono;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	

}
