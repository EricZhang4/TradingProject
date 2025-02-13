package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.modal.Order;
import com.zosh.modal.User;
import com.zosh.modal.Wallet;

@Service
public interface WalletService {
    Wallet getUserWallet(User user);
    Wallet addBalance(Wallet wallet, Long money);
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws Exception;
}
