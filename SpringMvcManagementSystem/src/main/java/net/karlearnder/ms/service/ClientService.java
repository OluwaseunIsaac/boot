package net.karlearnder.ms.service;

import java.util.List;

import net.karlearnder.ms.entity.Client;

public interface ClientService {
	List<Client> getAllClients();
	Client saveClient(Client client);
	Client fetchClientById(Long id);
	Client updateClient(Client client);
	void deleteClientById(Long id);
	

}
