package com.assignment.ecommerce.repository;

import com.assignment.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("from Product where name like CONCAT('%', :keyword, '%') or brand like CONCAT('%', :keyword, '%') or category like CONCAT('%', :keyword, '%') or releaseYear like :keyword")
    List<Product> findByKeyword(String keyword);
}
