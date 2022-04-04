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
		Query query = entityManager.createNativeQuery(""
				+ "insert into cliente (nombre, apellidos, dni, email, num_telefono, direccion) "
				+ "values (?1, ?2, ?3, ?4, ?5,?6)", Cliente.class);
		query.setParameter(1, c.getNombre());
		query.setParameter(2, c.getApellidos());
		query.setParameter(3, c.getDni());
		query.setParameter(4, c.getEmail());
		query.setParameter(5, c.getNumTelefono());
		query.setParameter(6, c.getDireccion());
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
		Query query = entityManager.createNativeQuery("Update Cliente set nombre = ?1, set apellidos = ?2, set dni = ?3, "
		+ "set direccion = ?4, set num_telefono = ?5, set email = ?6 where id = ?7", Cliente.class);
		query.setParameter(1, c.getNombre());
		query.setParameter(2, c.getApellidos());
		query.setParameter(3, c.getDni());
		query.setParameter(4, c.getDireccion());
		query.setParameter(5, c.getNumTelefono());
		query.setParameter(6, c.getEmail());
		query.setParameter(7, c.getId());
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
