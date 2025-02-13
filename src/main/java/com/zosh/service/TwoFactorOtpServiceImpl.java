
package com.zosh.service;

import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.modal.TwoFactorOTP;
import com.zosh.modal.User;
import com.zosh.repository.TwoFactorOtpRepository;


@Service
public class TwoFactorOtpServiceImpl implements TwoFactorOtpService {

    @Autowired
    private TwoFactorOtpRepository twoFactorOtpRepository;
    
    @Override
    public TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt) {
        // TODO Auto-generated method stub
        UUID uuid = UUID.randomUUID();
        
        String id = uuid.toString();
        
        TwoFactorOTP twoFactorOTP = new TwoFactorOTP();
        twoFactorOTP.setOtp(otp);
        twoFactorOTP.setJwt(jwt);
        twoFactorOTP.setId(id);
        twoFactorOTP.setUser(user);
        
        return twoFactorOtpRepository.save(twoFactorOTP);
    }

    @Override
    public TwoFactorOTP findByUser(Long userId) {
        // TODO Auto-generated method stub
        return twoFactorOtpRepository.findByUserId(userId);
    }

    @Override
    public TwoFactorOTP findById(String id) {
        // TODO Auto-generated method stub
        Optional<TwoFactorOTP> opt = twoFactorOtpRepository.findById(id);
        return opt.orElse(null);
        
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp) {
        // TODO Auto-generated method stub
        return twoFactorOtp.getOtp().equals(otp);
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOtp) {
        // TODO Auto-generated method stub
        twoFactorOtpRepository.delete(twoFactorOtp);
    }
    
    

}
