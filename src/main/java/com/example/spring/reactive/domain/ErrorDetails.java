package com.example.spring.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private String errorCode;
    private String errorMessage;


}
