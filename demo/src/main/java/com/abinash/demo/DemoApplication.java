package com.abinash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	//field injection
//	@Autowired
//	private RazorpayPaymentService razorpayPaymentService;
	// Constructor injection
//	private final RazorpayPaymentService razorpayPaymentService;
//	public DemoApplication(RazorpayPaymentService razorpayPaymentService) {
//		this.razorpayPaymentService = razorpayPaymentService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	RazorpayPaymentService razorpayPaymentService = new RazorpayPaymentService();

	private final PaymentService paymentService;

	public DemoApplication(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	// CommandLineRunner has one method called run which we have to implement
	@Override
	public void run(String... args)throws Exception{
		paymentService.pay();
	}
}
