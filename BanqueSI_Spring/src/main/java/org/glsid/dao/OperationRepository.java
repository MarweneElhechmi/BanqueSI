package org.glsid.dao;

import org.glsid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

// extends JPA<Entities,Id> : Spring va créer une implémentation dans laquelle 
// il va injecter toutes les opérations de bases

// Le fait d'hériter de JPA Repository , on a utiliser Spring Data qui n'est pas lié à Spring Boot

public interface OperationRepository extends JpaRepository<Operation, Long>{

	
}
