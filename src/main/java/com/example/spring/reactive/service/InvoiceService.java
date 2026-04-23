package com.example.spring.reactive.service;

import com.example.spring.reactive.entity.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceService {

    public Mono<com.example.spring.reactive.domain.Invoice> saveInvoice(Invoice invoice);
    public Flux<com.example.spring.reactive.domain.Invoice> findAllInvoices();
    public Mono<com.example.spring.reactive.domain.Invoice> getInvoice(Integer id);
    public Mono<Void> deleteInvoice(Integer id);
}
