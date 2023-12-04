package edu.unisabana.arqSoftware.restAPIdogdaycare.repository;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,String> {
    long countByClient(Client client);

    List<Pet> getReferenceByClient(Client client);

    Pet getReferenceByPetId(int petId);
}
