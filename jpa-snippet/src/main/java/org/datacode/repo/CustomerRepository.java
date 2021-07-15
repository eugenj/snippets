package org.datacode.repo;


import org.datacode.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    List<Customer> findByLastName(String lastName);

//    Customer findById(String id);
}