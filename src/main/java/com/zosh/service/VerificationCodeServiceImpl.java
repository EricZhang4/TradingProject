package com.zosh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.modal.User;
import com.zosh.modal.VerificationCode;
import com.zosh.repository.VerificationCodeRepository;
import com.zosh.utils.OtpUtils;

import com.zosh.domain.VerificationType;




@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;
    
    @Override
    public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {
        // TODO Auto-generated method stub
        VerificationCode verificationCode1 = new VerificationCode();
        verificationCode1.setOtp(OtpUtils.generateOTP());
        verificationCode1.setVerificationType(verificationType);
        verificationCode1.setUser(user);
        return verificationCodeRepository.save(verificationCode1);
    }


    

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception{
        // TODO Auto-generated method stub
        Optional<VerificationCode> verificationCode = 
            verificationCodeRepository.findById(id);
        if (verificationCode.isPresent()) {
            return verificationCode.get();
        }
        throw new Exception("verification code not found");
    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long userId) {
        // TODO Auto-generated method stub
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {
        // TODO Auto-generated method stub
        verificationCodeRepository.delete(verificationCode);
    }


    
    
}
