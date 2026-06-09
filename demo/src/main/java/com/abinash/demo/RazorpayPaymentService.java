package com.abinash.demo;

//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider",havingValue = "razor")
public class RazorpayPaymentService implements PaymentService {
    public void pay(){
        String payment = "Razorpay";
        System.out.println("payments from: "+payment);
    }
}
