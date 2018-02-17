package org.glsid.metier;

import java.util.Date;
import java.util.List;

import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.OperationRepository;
import org.glsid.entities.Compte;
import org.glsid.entities.Employe;
import org.glsid.entities.Operation;
import org.glsid.entities.Retrait;
import org.glsid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**********************************************************************/

// Si toutes les méthodes sont Transactional , alors on peut mettre 
// @Transactional sur la classe 

/* 
 * @Service
 * @Transactional
public class OperationMetierImpl implements OperationMetier{
CODE 
}
*/

/**********************************************************************/

@Service
public class OperationMetierImpl implements OperationMetier{

	@Autowired 
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired 
	private EmployeRepository employeRepository;
	
	/*****************************************************************/
	
	// Toutes les méthodes métiers doivent être transactionnel
	// On ouvre une transaction , on fait l'opération : 
	// Si tout ce passe bien , on fait tout et on ferme la transaction 
	// Sinon , on fait un rollback
	
	/*****************************************************************/
	
	@Override
	@Transactional
	public boolean verser(String codeCompte, double montant, Long codeEmploye) {
		
		/*******  OPERATIONS VERSEMENT    ********/
		Operation opVers = new Versement();
		opVers.setDateOperation(new Date());
		opVers.setMontantOpertaion(montant);
		
		/*******  TROUVER COMPTE    ********/
		Compte compteVers = compteRepository.findOne(codeCompte);
		opVers.setCompte(compteVers);
		
		/*******  TROUVER EMPLOYE    ********/
		Employe empVers = employeRepository.findOne(codeEmploye);
		opVers.setEmploye(empVers);
		
		/*******  AJOUT VERSEMENT    ********/
		operationRepository.save(opVers);
		
		/*******  MISE A JOUR SOLDE COMPTE    ********/
		compteVers.setSolde(compteVers.getSolde()+montant);
		
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String codeCompte, double montant, Long codeEmploye) {
		
		/*******  OPERATIONS RETRAIT    ********/
		Operation opRetr = new Retrait();
		opRetr.setDateOperation(new Date());
		opRetr.setMontantOpertaion(montant);
		
		/*******  TROUVER COMPTE    ********/
		Compte compteRetr = compteRepository.findOne(codeCompte);
		opRetr.setCompte(compteRetr);
		
		/*******  VERIFICATION SOLDE COMPTE PAR RAPPORT AU MONTANT RETRAIT    ********/
		if(compteRetr.getSolde()<montant)throw new RuntimeException("Solde Insuffisant");
		
		/*******  TROUVER EMPLOYE    ********/
		Employe empRetr = employeRepository.findOne(codeEmploye);
		opRetr.setEmploye(empRetr);
		
		/*******  AJOUT RETRAIT    ********/
		operationRepository.save(opRetr);
		
		/*******  MISE A JOUR SOLDE COMPTE    ********/
		compteRetr.setSolde(compteRetr.getSolde()-montant);
		
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String compte1, String compte2, double montant, Long codeEmploye) {

		retirer(compte1, montant, codeEmploye);
		verser(compte2, montant, codeEmploye);
		
		return true;
	}

	@Override
	public List<Operation> listOperation() {
		// TODO Auto-generated method stub
		return operationRepository.findAll();
	}


}
