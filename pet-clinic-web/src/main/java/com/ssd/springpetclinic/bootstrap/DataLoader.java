package com.ssd.springpetclinic.bootstrap;

import com.ssd.springpetclinic.model.Owner;
import com.ssd.springpetclinic.model.Pet;
import com.ssd.springpetclinic.model.PetType;
import com.ssd.springpetclinic.model.Vet;
import com.ssd.springpetclinic.services.OwnerService;
import com.ssd.springpetclinic.services.PetTypeService;
import com.ssd.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Thomson");
        owner1.setAddress("212,South Beacon Quarter");
        owner1.setCity("Dublin");
        owner1.setTelephone("34589908877");

        Pet johnsPet = new Pet();
        johnsPet.setName("Rockie");
        johnsPet.setPetType(savedDogType);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setOwner(owner1);
        owner1.getPets().add(johnsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Robert");
        owner2.setLastName("Williams");
        owner2.setAddress("123,Gates Sandyford");
        owner2.setCity("Dublin");
        owner2.setTelephone("45565709821");

        Pet robertsPet = new Pet();
        robertsPet.setName("Meow");
        robertsPet.setPetType(savedCatType);
        robertsPet.setBirthDate(LocalDate.now());
        robertsPet.setOwner(owner2);
        owner2.getPets().add(robertsPet);

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
