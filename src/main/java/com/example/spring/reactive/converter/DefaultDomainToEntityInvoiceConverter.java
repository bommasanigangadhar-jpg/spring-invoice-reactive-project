package com.example.spring.reactive.converter;

import com.example.spring.reactive.domain.Invoice;
import org.springframework.stereotype.Component;

@Component
public class DefaultDomainToEntityInvoiceConverter implements Converter<Invoice, com.example.spring.reactive.entity.Invoice> {


    @Override
    public com.example.spring.reactive.entity.Invoice convert(Invoice input) {
        com.example.spring.reactive.entity.Invoice output = new com.example.spring.reactive.entity.Invoice();
        output.setName(input.getName());
        output.setAmount(input.getAmount());
        output.setNumber(input.getNumber());
        return output;
    }
}
