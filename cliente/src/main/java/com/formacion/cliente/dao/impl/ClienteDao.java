package com.formacion.cliente.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.cliente.dao.IClienteDao;
import com.formacion.cliente.entities.Cliente;

@Repository
public class ClienteDao implements IClienteDao {
	
	/** The entity manager. */
	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	@Override
	public Cliente addCliente(Cliente c) {
//		Query query = entityManager.createNativeQuery(""
//				+ "insert into cliente (nombre, apellidos, dni, email, numTelefono, direccion) "
//				+ "values = ('" + c.getNombre() + "', '" + c.getApellidos()
//				+ "', '" + c.getDni() + "', '" + c.getEmail()
//				+ "', '" + c.getNumTelefono() + "', '" + c.getDireccion() + "')"
//				, Cliente.class);
		Query query = entityManager.createNativeQuery("INSERT INTO Cliente (nombre) VALUES =('edu')", Cliente.class);
		query.executeUpdate();
		return c;
	}

	@Transactional
	@Override
	public Cliente deleteCliente(int id) {
		Cliente c = entityManager.find(Cliente.class, id);
		Query query = entityManager.createNativeQuery("Delete from Cliente "
				+ "where id = ?1", Cliente.class);
		query.setParameter(1, id);
		query.executeUpdate();
		return c;
	}

	@Transactional
	@Override
	public Cliente updateCliente(Cliente c) {
//		Query query = entityManager.createNativeQuery(""
//				+ "Update Cliente set nombre = '" + c.getNombre() 
//				+ "', set apellidos = '" + c.getApellidos()
//				+ "', set dni = '" + c.getDni()
//				+ "', set direccion = '" + c.getDireccion()
//				+ "', set numTelefono = '" + c.getNumTelefono()
//				+ "', set email = '" + c.getEmail()
//				+ "' where id = ?1", Cliente.class);
		Query query = entityManager.createNativeQuery("Update cliente set nombre ='joao' where id=?1", Cliente.class);
		query.setParameter(1, c.getId());
		query.executeUpdate();
		return c;
	}
	
	@Override
	public Cliente getCliente(int id) {
		Cliente c = entityManager.find(Cliente.class, id);
		return c;
	}

	@Override
	public List<Cliente> getClientes() throws QueryTimeoutException {
		Query query = entityManager.createNativeQuery("Select * from Cliente", Cliente.class);
		List<Cliente> clientes = query.getResultList();
		
		return clientes;
	}
	
	

}
