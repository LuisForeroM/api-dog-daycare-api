package edu.unisabana.arqSoftware.restAPIdogdaycare.service;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Reserve;

import java.util.List;

public interface ReserveService {

    Boolean saveReserve(Reserve reserve);

    List<Pet> getPetsByReserveDate(String reserveDate);

    List<Reserve> getReservesByClientId(int clientId);
}
