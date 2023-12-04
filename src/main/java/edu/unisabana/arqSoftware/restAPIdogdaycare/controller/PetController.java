package edu.unisabana.arqSoftware.restAPIdogdaycare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.ClientService;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.PetService;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.communication.Publisher;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.impl.ClientServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pet")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {   RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.OPTIONS, RequestMethod.HEAD,
        RequestMethod.PATCH})
public class PetController {

    private PetService petService;
    private ClientService clientService;
    private Publisher publisher;

    public PetController(PetService petService,ClientService clientService,Publisher publisher) {
        this.clientService = clientService;
        this.petService = petService;
        this.publisher = publisher;

    }
    @RequestMapping(value = "/savePet",method = RequestMethod.POST)
    public boolean savePet(@RequestBody Pet pet){
        return petService.savePet(pet);
    }
    @RequestMapping(value= "/notifyClient", method= RequestMethod.POST)
    public boolean sendToRabbit(@RequestBody Pet pet) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Pet pet2 = petService.getPetById(pet.getPetId());
            if(pet !=null) {
                String json = objectMapper.writeValueAsString(pet2.getClient());
                this.publisher.send(json);
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }
    }

}
