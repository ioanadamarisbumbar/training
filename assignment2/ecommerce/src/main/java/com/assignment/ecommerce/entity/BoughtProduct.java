package com.assignment.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bought_products")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoughtProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Long userAccountNo;
    private Long eCommerceAccountNo;
    private Long quantity;
    private Double totalPrice;
    private LocalDate boughtAt;
}
