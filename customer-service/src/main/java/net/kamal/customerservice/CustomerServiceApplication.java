package net.kamal.customerservice;

import net.kamal.customerservice.entities.Customer;
import net.kamal.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList=List.of(
					Customer.builder()
							.firstname("kamal")
							.lastname("krami")
							.email("kamal@gmail.com")
							.build(),
					Customer.builder()
							.firstname("karim")
							.lastname("Elmakaoui")
							.email("karim@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
