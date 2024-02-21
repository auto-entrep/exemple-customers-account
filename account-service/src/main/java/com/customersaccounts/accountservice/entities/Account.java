package com.customersaccounts.accountservice.entities;

import com.customersaccounts.accountservice.enums.AccountType;
import com.customersaccounts.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.authenticator.SavedRequest;

import java.time.LocalDate;

@Getter  @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Account {
    @Id
    private String id;
    private LocalDate createDate;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;


}
