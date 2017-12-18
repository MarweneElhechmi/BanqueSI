package org.glsid.metier;

import java.util.List;

import org.glsid.dao.EmployeRepository;
import org.glsid.entities.Client;
import org.glsid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier{

	@Autowired 
	private EmployeRepository employeRepository;
	
	@Override
	public Employe saveEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> listEmploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
