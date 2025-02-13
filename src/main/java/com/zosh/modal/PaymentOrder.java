package com.zosh.modal;

import com.zosh.domain.PaymentMethod;
import com.zosh.domain.PaymentOrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;
    
    private PaymentOrderStatus status;
    
    private PaymentMethod paymentMethod;
    
    @ManyToOne
    private User user;
}
