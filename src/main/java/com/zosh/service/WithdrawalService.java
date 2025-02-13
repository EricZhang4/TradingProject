package com.zosh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zosh.modal.User;
import com.zosh.modal.Withdrawal;

@Service
public interface WithdrawalService {
    
    Withdrawal requestWithdrawal(Long amount, User user);
    
    Withdrawal proceedWithWithdrawal(Long withdrawalId, boolean accept) throws Exception;
    
    List<Withdrawal> getUsersWithdrawalHistory(User user);
    
    List<Withdrawal> getAllWithdrawalRequests();

    

}
