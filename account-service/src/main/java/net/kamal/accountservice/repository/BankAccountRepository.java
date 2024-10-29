package net.kamal.accountservice.repository;

import net.kamal.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false) // To deactivate Spring Data REST in the application
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
