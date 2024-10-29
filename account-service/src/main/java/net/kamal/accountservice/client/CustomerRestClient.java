package net.kamal.accountservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.kamal.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    // Communication between Microservices.

    @GetMapping("/customers")
    @CircuitBreaker(name = "CustomerService",fallbackMethod = "defaultfindAllCustomers")
    List<Customer> findAllCustomers();

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "CustomerService" , fallbackMethod = "defaultfindCustomerById")
    Customer findCustomerById(@PathVariable Long id);

    default Customer defaultfindCustomerById(Long id,Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstname("Not Available");
        customer.setLastname("Not Available");
        customer.setEmail("Not Available");
        return customer;
    }

    default List<Customer> defaultfindAllCustomers(Exception exception){
        return List.of();
    }
}
