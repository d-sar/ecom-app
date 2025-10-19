package com.enset.customerservice;

import com.enset.customerservice.config.CustomerConfigParams;
import com.enset.customerservice.entities.Customer;
import com.enset.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("sara")
                            .email("sara@gmail.com")
                            .build());
            customerRepository.save(Customer.builder()
                    .name("hamza")
                    .email("hamza@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("fati")
                    .email("fati@gmail.com")
                    .build());
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
