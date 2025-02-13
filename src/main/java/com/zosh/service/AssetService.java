package com.zosh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zosh.modal.Asset;
import com.zosh.modal.Coin;
import com.zosh.modal.User;

@Service
public interface AssetService {
    Asset createAsset(User user, Coin coin, double quantity);
    
    Asset getAssetById(Long assetId) throws Exception;
    
    Asset getAssetByUserIdandId(Long userId, Long assetId);
    
    List<Asset> getUsersAssets(Long userId);
    
    Asset updateAsset(Long assetId, double quantity) throws Exception;
    
    Asset findAssetByUserIdAndCoinId(Long userId, String coinId);
    
    void deleteAsset(Long assetId);
    
    
}
