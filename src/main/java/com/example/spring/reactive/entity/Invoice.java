package com.example.spring.reactive.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("invoice")
public class Invoice {

    @Id
    private Long id;
    private String name;
    private String number;
    private double amount;

}
