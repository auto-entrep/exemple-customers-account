package com.customersaccounts.accountservice;

import com.customersaccounts.accountservice.client.CustomerRestClient;
import com.customersaccounts.accountservice.entities.Account;
import com.customersaccounts.accountservice.enums.AccountType;
import com.customersaccounts.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);

	}


@Bean
CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){
	return args ->{

		customerRestClient.allCustomers().forEach(c->{

					Account account1 = Account.builder()
							.id(UUID.randomUUID().toString())
							.type(AccountType.Active_account)
							.createDate(LocalDate.now())
							.customerId(c.getId())
							.build();

					Account account2 = Account.builder()
							.id(UUID.randomUUID().toString())
							.type(AccountType.Inactif_account)
							.createDate(LocalDate.now())
							.customerId(c.getId())
							.build();

			accountRepository.save(account1);
			accountRepository.save(account2);

				}

		);


	};


	}
}
