package com.enset.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Product {
    @Id
    private String id ;
    private String name;
    private Double price;
    private int quantity;
}
