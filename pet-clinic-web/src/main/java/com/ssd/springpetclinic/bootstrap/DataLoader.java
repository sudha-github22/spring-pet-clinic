package com.ssd.springpetclinic.bootstrap;

import com.ssd.springpetclinic.model.Owner;
import com.ssd.springpetclinic.model.Vet;
import com.ssd.springpetclinic.services.OwnerService;
import com.ssd.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Thomson");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Robert");
        owner2.setLastName("Williams");
        ownerService.save(owner2);

        System.out.println("Loaded Owner Data......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Edwin");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Stephen");
        vet2.setLastName("Roy");
        vetService.save(vet2);

        System.out.println("Loaded Vet Data......");
    }
}
