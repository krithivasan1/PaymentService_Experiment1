package com.example.paymentservice_experiment1.services;

import com.razorpay.RazorpayException;

public interface PaymentService {
    public String initiatePayment(Long order_id,String name, int amount) throws RazorpayException;
}
