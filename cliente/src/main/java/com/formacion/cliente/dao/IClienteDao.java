package com.formacion.cliente.dao;

import java.util.List;

import javax.persistence.QueryTimeoutException;

import com.formacion.cliente.entities.Cliente;

public interface IClienteDao {
	
	/**
	 * Anade un cliente
	 * @param c el cliente a anadir
	 * @return el cliente anadido
	 */
	Cliente addCliente(Cliente c);
	
	/**
	 * Elimina un cliente
	 * @param id el id del cliente
	 * @return el cliente eliminado
	 */
	Cliente deleteCliente(int id);
	
	/**
	 * Actualizar cliente
	 * @param c el cliente a actualizar
	 * @return el cliente actualizado
	 */
	Cliente updateCliente(Cliente c);
	
	/**
	 * Devuelve el cliente con el id indicado
	 * @param id el id del cliente
	 * @return el cliente con el id indicado
	 */
	Cliente getCliente(int id);
	
	/**
	 * Devuelve todos los clientes
	 * @return todos los clientes
	 */
	List<Cliente> getClientes() throws QueryTimeoutException;

}
