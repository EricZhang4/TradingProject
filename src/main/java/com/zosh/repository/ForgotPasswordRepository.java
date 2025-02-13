package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.request.ForgotPasswordToken;




public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken, String> {
    
    ForgotPasswordToken findByUserId(Long userId);
}
