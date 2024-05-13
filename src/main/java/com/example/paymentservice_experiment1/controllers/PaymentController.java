package com.example.paymentservice_experiment1.controllers;


import com.example.paymentservice_experiment1.dtos.InitiatePaymentRequestDTO;
import com.example.paymentservice_experiment1.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/order_id")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO initiatePaymentRequestDTO) throws RazorpayException {

        return paymentService.initiatePayment(initiatePaymentRequestDTO.getOrder_id(),initiatePaymentRequestDTO.getName(),
                initiatePaymentRequestDTO.getAmount());
    }

}
