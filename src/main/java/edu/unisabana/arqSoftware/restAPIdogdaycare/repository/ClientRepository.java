package edu.unisabana.arqSoftware.restAPIdogdaycare.repository;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {


    Client getReferenceByDocumentClient(long documentClient);

    Client getByClientId(int clientId);
}
