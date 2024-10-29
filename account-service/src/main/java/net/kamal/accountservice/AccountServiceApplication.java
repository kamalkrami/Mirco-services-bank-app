package net.kamal.accountservice;

import net.kamal.accountservice.client.CustomerRestClient;
import net.kamal.accountservice.entities.BankAccount;
import net.kamal.accountservice.enums.AccountType;
import net.kamal.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.findAllCustomers().forEach(customer -> {
                List<BankAccount> bankAccountList = List.of(
                        BankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .currency("MAD")
                                .balance(Math.random()*82542)
                                .createAt(LocalDate.now())
                                .type(AccountType.CURRENT_ACCOUNT)
                                .customerId(customer.getId())
                                .build(),
                        BankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .currency("MAD")
                                .balance(Math.random()*6000)
                                .createAt(LocalDate.now())
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(customer.getId())
                                .build()
                );
                bankAccountRepository.saveAll(bankAccountList);
            });

        };
    }
}
