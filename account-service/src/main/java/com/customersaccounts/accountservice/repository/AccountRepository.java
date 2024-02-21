package com.customersaccounts.accountservice.repository;

import com.customersaccounts.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {

}
