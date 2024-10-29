package net.kamal.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.kamal.accountservice.enums.AccountType;
import net.kamal.accountservice.model.Customer;

import java.time.LocalDate;

@Entity @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.ORDINAL) // La forme avec laquelle le enum va être stockée dans la base de données (STRING(string) ou ORDINAL(1,0))
    private AccountType type;
    @Transient // utilisée en Java pour indiquer que la valeur d'un champ ne doit pas être sérialisée
    private Customer customer;
    private Long customerId;
}
