package br.com.engsoftware.appVoceAluga.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.engsoftware.appVoceAluga.domain.Client;
import br.com.engsoftware.appVoceAluga.repository.ClientRepository;



@RestController
@RequestMapping("/clientes")
public class ClientController {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@PostMapping("/cadastrarcliente")
	@ResponseBody
	public Client cadastrarClient(@RequestBody Client novoCliente) {
		return clientRepository.save(novoCliente);
	}

	
	@GetMapping("/clientes")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@PutMapping("/{id}")
	public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
		Optional<Client> optionalClient = clientRepository.findById(id);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.get();
			client.setNomeCompleto(updatedClient.getNomeCompleto());
			client.setDataNascimento(updatedClient.getDataNascimento());
			client.setCpf(updatedClient.getCpf());
			client.setEndereco(updatedClient.getEndereco());
			client.setNumeroTelefone(updatedClient.getNumeroTelefone());
			return clientRepository.save(client);
		} else {
			throw new RuntimeException("Client not found with id: " + id);
		}
	}

	public void deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}

}
