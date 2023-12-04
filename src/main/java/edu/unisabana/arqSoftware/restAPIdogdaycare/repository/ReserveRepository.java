package edu.unisabana.arqSoftware.restAPIdogdaycare.repository;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve,String> {
    long countByReserveDate(String reserveDate);
    boolean existsByReserveDateAndPet(String reserveDate, Pet pet);
    boolean existsByReserveDateAndClient(String reserveDate, Client client);
    List<Reserve> findByReserveDate(String reserveDate);

    List<Reserve> getReferenceByClient(Client client);
}


