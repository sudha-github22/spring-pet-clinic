package com.ssd.springpetclinic.bootstrap;

import com.ssd.springpetclinic.model.Owner;
import com.ssd.springpetclinic.model.Vet;
import com.ssd.springpetclinic.services.OwnerService;
import com.ssd.springpetclinic.services.VetService;
import com.ssd.springpetclinic.services.map.OwnerServiceMap;
import com.ssd.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Thomson");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Robert");
        owner2.setLastName("Williams");
        ownerService.save(owner1);

        System.out.println("Loading Owner Data......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Michael");
        vet1.setLastName("Edwin");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Stephen");
        vet2.setLastName("Roy");
        vetService.save(vet2);

        System.out.println("Loading Vet Data......");
    }
}
