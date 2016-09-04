package br.com.wansan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wansan.model.Cliente;
import br.com.wansan.repository.ClienteRepository;
import br.com.wansan.repsitory.filter.ClienteFilter;

@Service
public class ClienteService implements ClienteServiceInterface {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente findByCodigo(Long codigo) {
		return clienteRepository.findOne(codigo);
	}

	@Override
	public List<Cliente> searchFor(ClienteFilter filtro) {
		String nome = filtro.getRazao_social() == null ? "" : filtro.getRazao_social();
		return clienteRepository.findByNomeContaining(nome);
	}

	@Override
	public void create(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void update(Long codigo) {
		Cliente cliente = clienteRepository.findOne(codigo);
		clienteRepository.save(cliente);
	}

	@Override
	public void delete(Long codigo) {
		clienteRepository.delete(codigo);		
	}

	
	
}
