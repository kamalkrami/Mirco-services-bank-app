package net.kamal.customerservice.repository;

import net.kamal.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false) // To deactivate Spring Data REST in the application
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
