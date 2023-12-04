package edu.unisabana.arqSoftware.restAPIdogdaycare.service;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;

import java.util.List;

public interface ClientService {


    Boolean saveClient(Client client);


    Client getClientByDocument(long document);
}
