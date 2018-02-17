package org.glsid.services;

import java.util.List;

import org.glsid.entities.Operation;
import org.glsid.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {

	@Autowired
	private OperationMetier operationsMetier ;

	// On a utiliser PUT , parce que le versement c'est une mise à jour du solde.
	// Ici on a utiliser @RequestParam , parce que ce sont pas des données JSON
	// On va les envoyés dans le corps de la requêtte 
	
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(
			 @RequestParam String codeCompte
			,@RequestParam double montant
			,@RequestParam Long codeEmploye) {
		return operationsMetier.verser(codeCompte, montant, codeEmploye);
	}

	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(@RequestParam String codeCompte
			,@RequestParam double montant
			,@RequestParam Long codeEmploye) {
		return operationsMetier.retirer(codeCompte, montant, codeEmploye);
	}

	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(
			@RequestParam String compte1, 
			@RequestParam String compte2, 
			@RequestParam double montant, 
			@RequestParam Long codeEmploye) {
		return operationsMetier.virement(compte1, compte2, montant, codeEmploye);
	}

	@RequestMapping(value="/virements",method=RequestMethod.GET)
	public List<Operation> listOperation() {
		return operationsMetier.listOperation();
	}
	
	
	
}
