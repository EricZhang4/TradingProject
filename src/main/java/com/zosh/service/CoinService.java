package com.zosh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zosh.modal.Coin;

@Service
public interface CoinService {
    List<Coin> getCoinList(int page) throws Exception;
    
    String getMarketChart(String coinId, int days) throws Exception;
    
    String getCoinDetails(String coinId) throws Exception;
    
    Coin findById(String coinId) throws Exception;
    
    String searchCoin(String keyword) throws Exception;
    
    String getTop50CoinsByMarketCapRank() throws Exception;
    
    String getTreadingCoins() throws Exception;
}
