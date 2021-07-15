package org.datacode.repo;


import org.datacode.entity.Address;
import org.datacode.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {

}