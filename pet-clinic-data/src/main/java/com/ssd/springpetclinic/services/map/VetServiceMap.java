package com.ssd.springpetclinic.services.map;

import com.ssd.springpetclinic.model.Speciality;
import com.ssd.springpetclinic.model.Vet;
import com.ssd.springpetclinic.services.SpecialityService;
import com.ssd.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityService specialityService;
    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet object) {
        if(object!=null){
            if(object.getSpecialities().size()>0){
                object.getSpecialities().forEach(speciality -> {
                    if(speciality.getId()==null){
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
