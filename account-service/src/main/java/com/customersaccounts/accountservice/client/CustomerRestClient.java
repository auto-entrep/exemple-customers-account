package com.customersaccounts.accountservice.client;

import com.customersaccounts.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@FeignClient(name= "CUSTOMER-SERVICE")
public interface CustomerRestClient {
@GetMapping("/customers/{id}")
@CircuitBreaker(name= "customerService", fallbackMethod = "getDefaultCustomer")
Customer findCusomerById(@PathVariable Long id);
@GetMapping("/customers")
@CircuitBreaker(name= "customerService", fallbackMethod = "getAlltCustomer")
List<Customer> allCustomers();

default Customer getDefaultCustomer(Long id, Exception e){
    Customer customer= new Customer();
    customer.setId(id);
    customer.setFirtName("not available");
    customer.setLastName("not available");
    customer.setEmail("not available");
    return customer;
}

default List<Customer> getAlltCustomer(Exception e){
    return List.of();

}


}
