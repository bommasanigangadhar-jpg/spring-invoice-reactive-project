package com.example.spring.reactive.repository;

import com.example.spring.reactive.entity.Invoice;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends ReactiveCrudRepository<Invoice, Integer> {
}
