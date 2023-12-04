package edu.unisabana.arqSoftware.restAPIdogdaycare.service.impl;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.ClientRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.PetRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    public static final int LIMIT_OF_PETS_PER_CLIENT = 2;
    @Autowired
    private final PetRepository petRepository;
    @Autowired
    private final ClientRepository clientRepository;

    public PetServiceImpl(PetRepository petRepository, ClientRepository clientRepository) {

        this.petRepository = petRepository;
        this.clientRepository = clientRepository;

    }

    @Override
    public Boolean savePet(Pet pet) {
        try {

            Client client = clientRepository.getReferenceById(String.valueOf(pet.getClient().getClientId()));

            if (petRepository.countByClient(client) < LIMIT_OF_PETS_PER_CLIENT) {

                pet.setClient(client);
                petRepository.save(pet);

                return true;
            } else {

                return false;

            }

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Pet> getPetsByClientId(int clientId) {
        Client client = clientRepository.getByClientId(clientId);
        return petRepository.getReferenceByClient(client);
    }

    @Override
    public Pet getPetById(int petId) {

        return petRepository.getReferenceByPetId(petId);

    }


}
