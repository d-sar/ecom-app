package com.enset.billingservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter  @Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
