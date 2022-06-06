package com.ssd.springpetclinic.bootstrap;

import com.ssd.springpetclinic.model.*;
import com.ssd.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService,
                      SpecialityService specialityService,VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size()==0){
            loadData();
        }
    }
    private void loadData(){
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Pet robertsCat = new Pet();
        robertsCat.setName("Meow");
        robertsCat.setPetType(savedCatType);
        robertsCat.setBirthDate(LocalDate.now());
        robertsCat.setOwner(owner2);
        owner2.getPets().add(robertsCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(robertsCat);
        catVisit.setDescription("sneezy kitty ");
        catVisit.setDate(LocalDate.now());
        visitService.save(catVisit);

        System.out.println("Loaded Owner Data......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Edwin");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Stephen");
        vet2.setLastName("Roy");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vet Data......");
    }
}
