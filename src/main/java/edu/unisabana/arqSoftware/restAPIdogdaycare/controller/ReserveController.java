package edu.unisabana.arqSoftware.restAPIdogdaycare.controller;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Reserve;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.PetService;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.ReserveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/reserve")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {   RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.OPTIONS, RequestMethod.HEAD,
        RequestMethod.PATCH})
public class ReserveController {

    private ReserveService reserveService;
    private PetService petService;

    public ReserveController(ReserveService reserveService, PetService petService){

        this.reserveService = reserveService;
        this.petService = petService;

    }

    @RequestMapping(value="/saveReserve", method = RequestMethod.POST)
    public boolean saveReserve(@RequestBody Reserve reserve){
        return reserveService.saveReserve(reserve);

    }

    @GetMapping("/getPetsByReserveDate")
    public List<Pet> getPetsByReserveDate(@RequestParam("reserveDate") String reserveDate) {
        return reserveService.getPetsByReserveDate(reserveDate);
    }

}
