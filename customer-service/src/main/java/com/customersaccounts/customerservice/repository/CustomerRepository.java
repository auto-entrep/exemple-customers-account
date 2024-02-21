package com.customersaccounts.customerservice.repository;

import com.customersaccounts.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
