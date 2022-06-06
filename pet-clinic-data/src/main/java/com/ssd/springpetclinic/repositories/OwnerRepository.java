package com.ssd.springpetclinic.repositories;

import com.ssd.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    public Owner findByLastName(String lastName);
}
