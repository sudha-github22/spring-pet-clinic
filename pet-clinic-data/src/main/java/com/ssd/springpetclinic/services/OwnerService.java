package com.ssd.springpetclinic.services;

import com.ssd.springpetclinic.model.Owner;
import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String name);
}
