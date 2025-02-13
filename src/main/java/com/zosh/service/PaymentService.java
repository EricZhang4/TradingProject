package com.zosh.service;

import org.springframework.stereotype.Service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.zosh.domain.PaymentMethod;
import com.zosh.modal.PaymentOrder;
import com.zosh.response.PaymentResponse;
import com.zosh.modal.User;

@Service
public interface PaymentService {
    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);
    
    PaymentOrder getPaymentOrderById(Long id) throws Exception;
    
    Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException;
    
    PaymentResponse createRazorpayPaymentLing(User user, Long amount, Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLing(User user, Long amount, Long orderId) throws StripeException;
}
