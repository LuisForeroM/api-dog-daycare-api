package edu.unisabana.arqSoftware.restAPIdogdaycare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Reserve;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.ClientRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.ClientService;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.PetService;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.ReserveService;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.communication.Publisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/client")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {   RequestMethod.GET, RequestMethod.POST,
                                                                RequestMethod.PUT, RequestMethod.DELETE,
                                                                RequestMethod.OPTIONS, RequestMethod.HEAD,
                                                                RequestMethod.PATCH})

public class ClientController {

    private ClientService clientService;
    private PetService petService;
    private ReserveService reserveService;
    private Publisher publisher;

    public ClientController(ClientService clientService, PetService petService, ReserveService reserveService) {

        this.clientService = clientService;
        this.petService = petService;
        this.reserveService = reserveService;

    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public boolean saveClient(@RequestBody Client client) {

        return clientService.saveClient(client);

    }
    @GetMapping("/getPetsByDocument")
    public List<Pet> getPetsByDocument(@RequestParam("documentClient") long document) {
        Client client = clientService.getClientByDocument(document);
        return petService.getPetsByClientId(client.getClientId());
    }
    @GetMapping("/getReservesByClient")
    public List<Reserve> getReservesByClient(@RequestParam("documentClient") long document) {
        Client client = clientService.getClientByDocument(document);
        return reserveService.getReservesByClientId(client.getClientId());

    }
    @GetMapping("/getIdByDocument")
    public int getIdByDocument(@RequestParam("documentClient") long document)
    {
        Client client = clientService.getClientByDocument(document);
        return client.getClientId();
    }
}