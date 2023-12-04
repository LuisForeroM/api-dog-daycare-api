package edu.unisabana.arqSoftware.restAPIdogdaycare.service.impl;

import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Client;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Pet;
import edu.unisabana.arqSoftware.restAPIdogdaycare.model.Reserve;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.ClientRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.PetRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.repository.ReserveRepository;
import edu.unisabana.arqSoftware.restAPIdogdaycare.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    public static final int RESERVATION_LIMIT_PER_DAY = 20;
    @Autowired
    private final ReserveRepository reserveRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PetRepository petRepository;

    public ReserveServiceImpl(ReserveRepository reserveRepository, ClientRepository clientRepository, PetRepository petRepository) {
        this.reserveRepository = reserveRepository;
        this.clientRepository = clientRepository;
        this.petRepository = petRepository;

    }

    @Override
    public Boolean saveReserve(Reserve reserve) {
        try{

            Pet pet = petRepository.getReferenceById(String.valueOf(reserve.getPet().getPetId()));

            boolean isBelowReservationLimit = reserveRepository.countByReserveDate(reserve.getReserveDate()) < RESERVATION_LIMIT_PER_DAY;
            boolean isPetNotDuplicate = reserveRepository.existsByReserveDateAndPet(reserve.getReserveDate(), reserve.getPet());
            boolean isClientReserved = reserveRepository.existsByReserveDateAndClient(reserve.getReserveDate(), pet.getClient() );

            if(isBelowReservationLimit && !isPetNotDuplicate && !isClientReserved){


                Client client = pet.getClient();
                reserve.setClient(client);
                reserveRepository.save(reserve);
                return true;

            }else{

                return false;

            }



        }catch (Exception e){

            throw e;

        }

    }
    @Override
    public List<Pet> getPetsByReserveDate(String reserveDate) {
        List<Reserve> reserves = reserveRepository.findByReserveDate(reserveDate);
        List<Pet> pets = new ArrayList<>();

        for (Reserve reserve : reserves) {
            pets.add(reserve.getPet());
        }

        return pets;
    }
    @Override
    public List<Reserve> getReservesByClientId(int clientId) {
        Client client = clientRepository.getByClientId(clientId);
        return reserveRepository.getReferenceByClient(client);
    }


}
