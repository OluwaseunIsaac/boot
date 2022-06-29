package net.karlearnder.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.karlearnder.ms.entity.Client;
import net.karlearnder.ms.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	//autowired not needed because we have only one constructor created
	private ClientService clientService;

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	//handler method to handle client list and return model and view 
	@GetMapping("/clients")
	public String clientList(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "clients";
		
	}
	
	@GetMapping("/client/new")
	public String addClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "add_client";
	}
	
	@PostMapping("/clients")
	public String saveClient(@ModelAttribute("client") Client client) {
		clientService.saveClient(client);
		return "redirect:/clients";
	}
	
	
	@GetMapping("/client/fetch/{id}")
	public String fetchClientInfo(@PathVariable Long id, Model model ) {
		model.addAttribute("client", clientService.fetchClientById(id));
		return "update_client";
	}

	
	@PutMapping("/client/{id}")
	public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client, Model model ) {
		//get client from database by id
		Client existingClient = clientService.fetchClientById(id);
		existingClient.setId(id);
		existingClient.setFirstName(client.getFirstName());
		existingClient.setLastName(client.getLastName());
		existingClient.setEmail(client.getEmail());
		
		//save updates
		clientService.updateClient(existingClient);
		return "redirect:/clients";
	}
	
	
	@GetMapping("/client/fetchForDelete/{id}")
	public String fetchInfo(@PathVariable Long id, Model model ) {
		model.addAttribute("client", clientService.fetchClientById(id));
		return "delete_client";
	}
	
	//Handler Method for deleting client profile	
	@DeleteMapping("/client/delete/{id}")
	public String deleteClient(@PathVariable Long id, Client client) {
		clientService.deleteClientById(id);
		return "redirect:/clients";
	}
	

}
