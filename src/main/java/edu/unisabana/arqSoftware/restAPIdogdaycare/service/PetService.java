package edu.unisabana.arqSoftware.restAPIdogdaycare.service;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Reserve;

import java.util.List;

public interface PetService {
    Boolean savePet(Pet pet);


    List<Pet> getPetsByClientId(int clientId);

    Pet getPetById(int petId);
}
