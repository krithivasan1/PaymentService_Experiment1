package com.example.paymentservice_experiment1.services;


import com.example.paymentservice_experiment1.services.paymentgateway.PaymentGateway;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentServiceImpl(@Qualifier("razorPaymentGateway")PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    @Override
    public String initiatePayment(Long order_id, String name, int amount) throws RazorpayException {
        return paymentGateway.generatePaymentLink(order_id,name,amount);

    }
}
