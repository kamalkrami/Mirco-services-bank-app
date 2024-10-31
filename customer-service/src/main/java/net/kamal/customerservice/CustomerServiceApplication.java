package net.kamal.customerservice;

import net.kamal.customerservice.config.GlobalConfig;
import net.kamal.customerservice.entities.Customer;
import net.kamal.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class) // To activate the service it will use the GlobalConfig class to configure itself
@RefreshScope
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
