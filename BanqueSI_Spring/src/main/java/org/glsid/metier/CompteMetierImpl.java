package org.glsid.metier;

import java.util.Date;
import java.util.List;

import org.glsid.dao.CompteRepository;
import org.glsid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier{

	@Autowired 
	private CompteRepository compteRepository;
	
	@Override
	public Compte saveCompte(Compte compte) {
		compte.setDateCreation(new Date());
		return compteRepository.save(compte);
	}

	@Override
	public List<Compte> listCompte() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.findOne(code);
	}

}
