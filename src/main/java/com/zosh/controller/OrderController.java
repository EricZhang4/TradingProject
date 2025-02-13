package com.zosh.controller;

import java.util.List;

import com.zosh.modal.Order;
import com.zosh.request.CreateOrderRequest;
import com.zosh.service.CoinService;
import com.zosh.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zosh.modal.*;

import com.zosh.service.*;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private CoinService coinService;

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
        @RequestHeader("Authorization") String jwt,
        @RequestBody CreateOrderRequest req
    ) throws Exception {
       User user = userService.findUserProfileByJwt(jwt);
       Coin coin = coinService.findById(req.getCoinId());

       Order order = orderService.processOrder(coin, req.getQuantity(), req.getOrderType(), user);
       
       return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@RequestHeader("Authorization") String jwtToken,
    @PathVariable Long orderId) throws Exception {
        User user = userService.findUserProfileByJwt(jwtToken);
        
        Order order = orderService.getOrderById(orderId);
        if (order.getUser().getId().equals(user.getId())) {
            return ResponseEntity.ok(order);
        }
        else {
            throw new Exception("you don't have access");
        }
    }
    
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(
        @RequestHeader("Authorization") String jwt,
        @RequestParam(required = false) String order_type,
        @RequestParam(required = false) String asset_symbol
    ) throws Exception {
        
        Long userId = userService.findUserProfileByJwt(jwt).getId();
        List<Order> userOrders = orderService.getAllOrdersOfUser(userId, order_type, asset_symbol);
        return ResponseEntity.ok(userOrders);
    }
}
