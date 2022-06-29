package net.karlearnder.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.karlearnder.ms.entity.Client;
import net.karlearnder.ms.repository.ClientRepository;
import net.karlearnder.ms.service.ClientService;


@Service
public class ClientServiceImpl implements ClientService{
	
	
	@Autowired
	private ClientRepository clientRepository;
	//have all CRUD in it
	

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}



	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}



	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}



	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}



	@Override
	public Client fetchClientById(Long id) {
		return clientRepository.findById(id).get();
	}



	@Override
	public void deleteClientById(Long id) {
		clientRepository.deleteById(id);
	}
	

}
