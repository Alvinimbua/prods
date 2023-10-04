package com.imbuka.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Product name shouldn't be NULL or EMPTY")
    private String name;
    @Min(value = 100, message = "Product price cant be less than 1500")
    private double price;
    @NotBlank(message ="Product description shouldn't be NULL or EMPTY ")
    private String description;
    @NotEmpty(message = "Product type must be present")
    private String productType;
}
