package com.abinash.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService{
    @Override
    public void pay() {
        String payment = "Stripe";
        System.out.println("payment option: "+payment);
    }
}
