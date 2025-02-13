package com.zosh.service;

import com.zosh.modal.*;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zosh.domain.*;

@Service
public interface OrderService {
    
    Order createOrder(User user, OrderItem orderItem, OrderType orderType);
    
    Order getOrderById(Long orderId) throws Exception;
    
    List<Order> getAllOrdersOfUser(Long userId, String orderType, String assetSymbol);
    
    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
    
}
