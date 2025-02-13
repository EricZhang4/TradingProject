package com.zosh.service;

import com.zosh.domain.VerificationType;



import com.zosh.modal.User;

import com.zosh.request.ForgotPasswordToken;




public interface ForgotPasswordService {
    
    ForgotPasswordToken createToken(User user, 
    String id, String otp, VerificationType verificationType,
    String sendTo
    );
    
    ForgotPasswordToken findById(String id);
    
    ForgotPasswordToken findByUser(Long userId);
    
    void deleteToken(ForgotPasswordToken token);
    
}
