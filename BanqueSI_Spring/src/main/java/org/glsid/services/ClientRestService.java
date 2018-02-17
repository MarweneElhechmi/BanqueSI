package org.glsid.services;

import java.util.List;

import org.glsid.entities.Client;
import org.glsid.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Gérer le Client à partir d'un service RESTFUL 
//Pour définir un controleur qui va fonctionner en mode REST
@RestController
public class ClientRestService {
	//Injection des dépendances avec @Autowired
	@Autowired
	private ClientMetier clientMetier ;
	
	/************************************************/

	// POST AJOUT
	// GET LISTER 
	// PUT UPDATE
	// DELETE SUPPRIMER 
	
	/************************************************/

	//1. Si vous envoyez une requette avec GET au client , vous aurez la liste.
	
	//2. Si vous envoyez une requette avec POST au client , vous allez ajouter un client.
	//Les données du client seront envoyées en format JSON.
	//Alors on ajoute @RequestBody
	// Récupérer les données de la requêtte (du client) dans le corps de la requette 
	// et ces données là , sont en format JSON et aprés il va les diserializés 
	
	// @ResponseBody
	/*@ResponseBody
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}*/
	// Le résultat va être généré en format JSON dans le corps de la réponse 
	//Mais lorsqu'on utilise @RestController , on peut n'a pas besoin de spécifier @ResponseBody
	//Implicite , on suppose que tout ce qui va être retourné va être en format JSON
	//On l'utilise , si on met : 
	/* @Controller
	public class ClientRestService {
	}
*/
	
	/*************************************************/
	
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	} 
	
	

}
