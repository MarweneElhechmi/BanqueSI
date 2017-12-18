package org.glsid.services;

import java.util.List;

import org.glsid.entities.Employe;
import org.glsid.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {

	@Autowired
	private EmployeMetier employeMetier ;
	
	//Si on utilise pas @RequestBody
	// Il récupére pas les données qui se trouvent dans le corps de la requette 
	
	
	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe employe) {
		return employeMetier.saveEmploye(employe);
	}

	@RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employe> listEmploye() {
		return employeMetier.listEmploye();
	} 
}
