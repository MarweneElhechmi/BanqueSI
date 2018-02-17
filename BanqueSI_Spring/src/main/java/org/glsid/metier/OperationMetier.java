package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Operation;

public interface OperationMetier {
	
	public boolean verser(String codeCompte,double montant,Long codeEmploye) ;
	
	public boolean retirer(String codeCompte,double montant,Long codeEmploye) ;
	
	public boolean virement(String compte1,String compte2,double montant,Long codeEmploye) ;
	
	public List<Operation> listOperation();


}
