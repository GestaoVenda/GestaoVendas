package br.com.wansan.service;

import java.util.List;

import br.com.wansan.model.Cliente;
import br.com.wansan.repsitory.filter.ClienteFilter;

public interface ClienteServiceInterface {

	
	Cliente findByCodigo(Long codigo);
	
	List<Cliente> searchFor(ClienteFilter filtro);
	
	void create(Cliente cliente);
	
	void update(Long codigo);
	
	void delete (Long codigo);
	
}
