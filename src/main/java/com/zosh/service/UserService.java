package com.zosh.service;

import com.zosh.modal.User;

import org.springframework.stereotype.Service;

import com.zosh.domain.VerificationType;

@Service
public interface UserService {
    public User findUserProfileByJwt(String jwt) throws Exception;
    public User findUserByEmail(String email);
    public User findUserById(Long userid) throws Exception;
    
    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user);
    
    User updatePassword(User user, String newPassword);
}
