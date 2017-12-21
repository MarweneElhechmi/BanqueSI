package org.glsid.services;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.glsid.entities.Compte;
import org.glsid.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {
	
	@Autowired
	private CompteMetier compteMetier ;

	/**********************************************************/

	// Le mapping Objet -- JSON se fait par JACKSON ou ( GSON pour application Mobile ).
	// JACKSON c'est l'équivalent de JAX-B.
	// JAX-B fait le mapping Objet -- XML.
	
	/**********************************************************/

	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}

	@RequestMapping(value="/comptes",method=RequestMethod.GET)
	public List<Compte> listCompte() {
		return compteMetier.listCompte();
	}

	/**********************************************************/
	
	//POUR SPRING : @PathVariable.
	// @PathParam ( JAX-RS <--> RESTFUL ).
	//On utilise @RestController donc Spring.
	
	/**********************************************************/
	
	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
	
	
}
