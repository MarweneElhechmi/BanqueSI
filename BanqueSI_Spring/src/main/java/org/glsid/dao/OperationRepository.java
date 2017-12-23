package org.glsid.dao;

import org.glsid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

//extends JPA<Entities,Id> : Spring va créer une implémentation dans laquelle 
// il va injecter toutes les opérations de bases

public interface OperationRepository extends JpaRepository<Operation, Long>{

	
}
