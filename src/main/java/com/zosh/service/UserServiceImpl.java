package com.zosh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.config.JwtProvider;
import com.zosh.domain.VerificationType;
import com.zosh.modal.TwoFactorAuth;
import com.zosh.modal.User;
import com.zosh.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUserProfileByJwt(String jwt) throws Exception{
        // TODO Auto-generated method stub
        String email = JwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            throw new Exception("user not found");
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserByEmail'");
    }

    @Override
    public User findUserById(Long userId) throws Exception{
        // TODO Auto-generated method stub
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new Exception("user not found");
        }
        return user.get();
    }

    

    @Override
    public User updatePassword(User user, String newPassword) {
        // TODO Auto-generated method stub
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    @Override
    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
        // TODO Auto-generated method stub
        TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);
        
        user.setTwoFactorAuth(twoFactorAuth);
        
        return userRepository.save(user);
    }

}
