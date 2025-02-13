package com.zosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.modal.PaymentDetails;
import com.zosh.modal.User;
import com.zosh.repository.PaymentDetailsRepository;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService{

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderName, String ifsc,
            String bankName, User user) {
        // TODO Auto-generated method stub
        PaymentDetails paymentDetails = new PaymentDetails();
        
        paymentDetails.setAccountNumber(accountNumber);
        paymentDetails.setAccountHolderName(accountHolderName);
                paymentDetails.setIfsc(ifsc);

        throw new UnsupportedOperationException("Unimplemented method 'addPaymentDetails'");
    }

    @Override
    public PaymentDetails getUserPaymentDetails(User user) {
        // TODO Auto-generated method stub
        return paymentDetailsRepository.findByUserId(user.getId());
    }
}
