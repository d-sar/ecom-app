package com.enset.billingservice.repo;

import com.enset.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItmRepository extends JpaRepository<ProductItem,Long> {
}
