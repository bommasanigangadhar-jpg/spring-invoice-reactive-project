package com.example.spring.reactive.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Invoice {

    private String name;
    private String number;
    private double amount;
}
