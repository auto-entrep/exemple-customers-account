package com.customersaccounts.accountservice.web;

import com.customersaccounts.accountservice.client.CustomerRestClient;
import com.customersaccounts.accountservice.entities.Account;
import com.customersaccounts.accountservice.model.Customer;
import com.customersaccounts.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@RestController
public class AccountRestController {

    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

@GetMapping("/accounts/{id}")
public Account accountById(@PathVariable String id){

        Account account= accountRepository.findById(id).get();
        Customer customer=customerRestClient.findCusomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
}

    @GetMapping("/accounts")
    public List<Account> accountList(){

        List<Account> accountList= accountRepository.findAll();

        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCusomerById(acc.getCustomerId()));

                }

                );
    return  accountList;
    }


    /*@GetMapping("/accounts/{id}")
public Account accountById(@PathVariable String id){


        return accountRepository.findById(id).get();
}
   @GetMapping("/accounts")
    public List<Account> accountList(){

        return accountRepository.findAll();
}


*/
}
