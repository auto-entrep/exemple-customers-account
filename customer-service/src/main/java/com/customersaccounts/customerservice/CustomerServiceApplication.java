package com.customersaccounts.customerservice;

import com.customersaccounts.customerservice.config.GlobalConfig;
import com.customersaccounts.customerservice.entities.Customer;
import com.customersaccounts.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);

	}


@Bean
CommandLineRunner commandLineRunner(CustomerRepository customerRepository){

		return args -> {
			List<Customer> customerList= List.of(
					Customer.builder()
							.firtName("driss")
							.lastName("el-driss")
							.email("driss@gmail.com")
							.build(),
					Customer.builder()
							.firtName("mohamed")
							.lastName("kamal")
							.email("mkamal@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};

/*		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

			}
		};*/
	}

}
