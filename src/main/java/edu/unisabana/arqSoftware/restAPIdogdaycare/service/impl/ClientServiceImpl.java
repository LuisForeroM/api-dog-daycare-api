package edu.unisabana.arqSoftware.restAPIdogdaycare.service.impl;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.ClientRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.PetRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){

        this.clientRepository = clientRepository;


    }
    @Override
    public Boolean saveClient(Client client) {
        try{


            clientRepository.save(client);
            return true;

        }catch (Exception e) {

            throw e;

        }

    }
    @Override
    public Client getClientByDocument(long document) {
        return clientRepository.getReferenceByDocumentClient(document);
    }

}
