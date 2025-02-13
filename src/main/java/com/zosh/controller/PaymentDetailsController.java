package com.zosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.modal.PaymentDetails;
import com.zosh.modal.*;
import com.zosh.service.PaymentDetailsService;
import com.zosh.service.UserService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;





import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class PaymentDetailsController {
    @Autowired
    private UserService userService;

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @PostMapping("/payment-details")
    public ResponseEntity<PaymentDetails> addPaymentDetails(
        @RequestBody PaymentDetails paymentDetailsRequest,
        @RequestHeader("Authorization") String jwt) throws Exception {
        
        User user = userService.findUserProfileByJwt(jwt);
        PaymentDetails paymentDetails = paymentDetailsService.addPaymentDetails(
            paymentDetailsRequest.getAccountNumber(),
            paymentDetailsRequest.getAccountHolderName(),
            paymentDetailsRequest.getIfsc(),
            paymentDetailsRequest.getBankName(),
            user);
        
        return new ResponseEntity<>(paymentDetails, HttpStatus.CREATED);
    }

    @GetMapping("/payment-details")
    public ResponseEntity<PaymentDetails> getUsersPaymentDetails(
        @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        
        PaymentDetails paymentDetails = paymentDetailsService.getUserPaymentDetails(user);
        return new ResponseEntity<>(paymentDetails, HttpStatus.CREATED);
        
    }
}
