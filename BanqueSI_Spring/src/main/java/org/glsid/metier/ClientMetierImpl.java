package org.glsid.metier;

import java.util.List;

import org.glsid.dao.ClientRepository;
import org.glsid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Pour considerer que cette classe comme un bean Spring on utilise @Service
//Générélement on utilise @Service pour les objets de la couche métier
//Injection des dépendances via XML ou annotations
//On peut utiliser aussi @Component
//Si on ne fait pas @Service ou @Component , @Autowired ne vas pas marcher
@Service
public class ClientMetierImpl implements ClientMetier{
	//Autowired pour implementer automatiquement l'interface Repository
	//Spring injecte une implementation 
	@Autowired 
	private ClientRepository clientRepository;
	
	@Override
	public Client saveClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
