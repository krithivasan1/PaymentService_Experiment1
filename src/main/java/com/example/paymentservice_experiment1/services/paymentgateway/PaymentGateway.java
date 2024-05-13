package com.example.paymentservice_experiment1.services.paymentgateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generatePaymentLink(Long orderid,String name, int amount) throws RazorpayException;
    boolean validatePayment(Long orderId);
}
