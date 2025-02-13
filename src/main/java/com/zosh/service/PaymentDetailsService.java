package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.modal.PaymentDetails;
import com.zosh.modal.User;

@Service
public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber, 
    String accountHolderName, String ifsc, String bankName, User user);
    public PaymentDetails getUserPaymentDetails(User user);
    
    
}
