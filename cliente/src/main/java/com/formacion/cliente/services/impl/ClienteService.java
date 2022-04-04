package com.formacion.cliente.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.QueryTimeoutException;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.cliente.dao.IClienteDao;
import com.formacion.cliente.entities.Cliente;
import com.formacion.cliente.services.IClienteService;

@Service
public class ClienteService implements IClienteService {

	private static final Logger LOGGER = ESAPI.getLogger(ClienteService.class);
	
	@Autowired
	private IClienteDao clientesDao;
	
	@Override
	public Cliente addCliente(Cliente c) {
		return this.clientesDao.addCliente(c);
	}

	@Override
	public Cliente deleteCliente(int id) {
		return this.clientesDao.deleteCliente(id);
	}

	@Override
	public Cliente updateCliente(Cliente c) {
		return this.clientesDao.updateCliente(c);
	}

	@Override
	public Cliente getCliente(int id) {
		return this.clientesDao.getCliente(id);
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> result = new ArrayList<Cliente>();
		try {
			result = this.clientesDao.getClientes();
		} catch(QueryTimeoutException e) {
			LOGGER.error(Logger.EVENT_FAILURE, "No se ha podido completar la query", e);
		}
		
		return result;
	}

}
