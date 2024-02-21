package com.customersaccounts.accountservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String firtName;
    private String lastName;
    private String email;

}