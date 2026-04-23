package com.example.spring.reactive.controller;

import com.example.spring.reactive.converter.DefaultDomainToEntityInvoiceConverter;
import com.example.spring.reactive.domain.Invoice;
import com.example.spring.reactive.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final DefaultDomainToEntityInvoiceConverter domainToEntityInvoiceConverter;

    public InvoiceController(InvoiceService invoiceService,
                             DefaultDomainToEntityInvoiceConverter domainToEntityInvoiceConverter) {
        this.invoiceService = invoiceService;
        this.domainToEntityInvoiceConverter = domainToEntityInvoiceConverter;
    }

    @PostMapping("/invoice")
    public Mono<Invoice> persistInvoices(@RequestBody Invoice invoice) {
       return invoiceService.saveInvoice(domainToEntityInvoiceConverter.convert(invoice));
    }

    @GetMapping("/invoice/all")
    public Flux<Invoice> fetchAllInvoices(){
        return invoiceService.findAllInvoices();
    }

    @GetMapping("/invoice/{id}")
    public Mono<Invoice> getInvoice(@PathVariable(name = "id") Integer id){
        return  invoiceService.getInvoice(id);
    }

    @DeleteMapping("/invoice/{id}")
    public Mono<String> deleteInvoice(@PathVariable(name = "id") Integer id){
        Mono<Void> voidMono = invoiceService.deleteInvoice(id);
        voidMono.subscribe();
        return Mono.just("Invoice with id: "+ id+ " deleted.");
    }

}
