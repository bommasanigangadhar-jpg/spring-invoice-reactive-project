package com.example.spring.reactive.converter;

import com.example.spring.reactive.domain.Invoice;
import org.springframework.stereotype.Component;

@Component
public class DefaultEntityToDomainInvoiceConverter implements Converter<com.example.spring.reactive.entity.Invoice, Invoice> {


    @Override
    public Invoice convert(com.example.spring.reactive.entity.Invoice input) {
        Invoice output = new Invoice();
        output.setName(input.getName());
        output.setAmount(input.getAmount());
        output.setNumber(input.getNumber());
        return output;
    }
}
