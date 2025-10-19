package com.enset.billingservice;

import com.enset.billingservice.entities.Bill;
import com.enset.billingservice.entities.ProductItem;
import com.enset.billingservice.feign.CustomerRestClient;
import com.enset.billingservice.feign.ProductRestClient;
import com.enset.billingservice.model.Customer;
import com.enset.billingservice.model.Product;
import com.enset.billingservice.repo.BillRepository;
import com.enset.billingservice.repo.ProductItmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
@Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItmRepository productRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {
            Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(1+new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();
                    productRepository.save(productItem);
                });
            });

        };
    }
}
