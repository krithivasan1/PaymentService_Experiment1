package com.example.paymentservice_experiment1.services.paymentgateway;

public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderid, String name, int amount) {
        return null;
    }

    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}
