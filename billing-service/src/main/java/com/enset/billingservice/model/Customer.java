package com.enset.billingservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Customer {
    private Long id;
    private String name;
    private String email ;
}
