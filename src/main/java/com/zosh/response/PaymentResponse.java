package com.zosh.response;

import com.razorpay.Payment;
import com.zosh.modal.PaymentOrder;
import com.zosh.modal.User;

import lombok.Data;

@Data
public class PaymentResponse {
    private String payment_url;
}
