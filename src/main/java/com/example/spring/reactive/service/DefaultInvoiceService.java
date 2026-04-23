package com.example.spring.reactive.service;

import com.example.spring.reactive.converter.DefaultEntityToDomainInvoiceConverter;
import com.example.spring.reactive.entity.Invoice;
import com.example.spring.reactive.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DefaultInvoiceService implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final DefaultEntityToDomainInvoiceConverter entityToDomainInvoiceConverter;
    public DefaultInvoiceService(InvoiceRepository invoiceRepository,
                                 DefaultEntityToDomainInvoiceConverter entityToDomainInvoiceConverter){
        this.invoiceRepository = invoiceRepository;
        this.entityToDomainInvoiceConverter = entityToDomainInvoiceConverter;
    }

    @Override
    public Mono<com.example.spring.reactive.domain.Invoice> saveInvoice(Invoice invoice) {
        Mono<Invoice> invoiceMono = invoiceRepository.save(invoice);
        return invoiceMono.map(entityToDomainInvoiceConverter::convert);
    }

    @Override
    public Flux<com.example.spring.reactive.domain.Invoice> findAllInvoices() {
        Flux<Invoice> invoiceFlux =  invoiceRepository.findAll();
        return invoiceFlux.map(entityToDomainInvoiceConverter::convert);
    }

    @Override
    public Mono<com.example.spring.reactive.domain.Invoice> getInvoice(Integer id) {
        Mono<Invoice> invoiceMono = invoiceRepository.findById(id);
        return invoiceMono.map(entityToDomainInvoiceConverter::convert).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> deleteInvoice(Integer id) {
        return invoiceRepository.deleteById(id);
    }
}
