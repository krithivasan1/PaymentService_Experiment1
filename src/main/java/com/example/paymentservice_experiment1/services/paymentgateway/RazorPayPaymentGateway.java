package com.example.paymentservice_experiment1.services.paymentgateway;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.razorpay.RazorpayClient;

@Service("razorPaymentGateway")
public class RazorPayPaymentGateway implements PaymentGateway {

    private RazorpayClient razorpayClient;

    public RazorPayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(Long orderid, String name, int amount) throws RazorpayException {
        // Call the razor payment api to get the payment Link
        // Code from Razor Pay docs -
        // https://razorpay.com/docs/api/payments/payment-links/create-standard?search-string=/v1/payment_links

// Change the reference id every time you are sending 
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount);
        paymentLinkRequest.put("currency", "INR");
       // paymentLinkRequest.put("accept_partial", true);
        //paymentLinkRequest.put("first_min_partial_amount", 100);
        paymentLinkRequest.put("expire_by", 1715542152);
        paymentLinkRequest.put("reference_id", "TS19895656567");
        paymentLinkRequest.put("description", "Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name", "+919000090000");
        customer.put("contact", "Krithivasan");
        customer.put("email", "krithi.vn@gmail.com");
        paymentLinkRequest.put("customer", customer);
        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name", "Jeevan Bima");
        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://www.scaler.com/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }

    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}
