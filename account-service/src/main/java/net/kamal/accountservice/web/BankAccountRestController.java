package net.kamal.accountservice.web;

import lombok.AllArgsConstructor;
import net.kamal.accountservice.client.CustomerRestClient;
import net.kamal.accountservice.entities.BankAccount;
import net.kamal.accountservice.model.Customer;
import net.kamal.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @AllArgsConstructor
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClinet;

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClinet.findCustomerById(bankAccount.getCustomerId()));
        });
        return bankAccountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClinet.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
