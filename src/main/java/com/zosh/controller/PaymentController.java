package com.zosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.stripe.exception.StripeException;

import com.zosh.service.PaymentService;
import com.zosh.service.UserService;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.zosh.modal.*;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;


import com.razorpay.RazorpayException;

import com.zosh.domain.PaymentMethod;
import com.zosh.response.PaymentResponse;


@RestController
public class PaymentController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
    public ResponseEntity<PaymentResponse> paymentHandler(
        @PathVariable PaymentMethod paymentMethod,
        @PathVariable Long amount,
        @RequestHeader("Authorization") String jwt) throws Exception,
        RazorpayException,
        StripeException {
        
        User user = userService.findUserProfileByJwt(jwt);
        
        PaymentResponse paymentResponse;
        
        PaymentOrder order = paymentService.createOrder(user, amount, paymentMethod);
        
        if (paymentMethod.equals(PaymentMethod.RAZORPAY)) {
            paymentResponse = paymentService.createRazorpayPaymentLing(user, amount, order.getId());
        }
        else {
            paymentResponse = paymentService.createStripePaymentLing(user, amount, order.getId());
        }
        
        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }
}

