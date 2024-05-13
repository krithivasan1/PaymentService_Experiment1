package com.example.paymentservice_experiment1.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDTO {

    private Long order_id;
    private String name;
    private int amount ;
}
