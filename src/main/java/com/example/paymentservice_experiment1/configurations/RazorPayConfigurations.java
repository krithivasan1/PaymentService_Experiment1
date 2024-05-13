package com.example.paymentservice_experiment1.configurations;


import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfigurations {
    @Value("${razor.keys.id}")
    String razorKey ;
    @Value("${razor.keys.secret}")
    String razorSecret;
    @Bean
    public RazorpayClient getRazorPayClient() throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(razorKey, razorSecret);
        return razorpay;

    }
}
