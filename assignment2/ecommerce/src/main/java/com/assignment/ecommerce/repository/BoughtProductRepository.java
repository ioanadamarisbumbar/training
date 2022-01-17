package com.assignment.ecommerce.repository;

import com.assignment.ecommerce.entity.BoughtProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtProductRepository extends JpaRepository<BoughtProduct, Long> {
}
