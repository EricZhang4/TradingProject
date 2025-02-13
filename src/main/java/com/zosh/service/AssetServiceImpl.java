package com.zosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.modal.Asset;
import com.zosh.modal.Coin;
import com.zosh.modal.User;
import com.zosh.repository.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService{
    @Autowired
    private AssetRepository assetRepository;
    
    @Override
    public Asset createAsset(User user, Coin coin, double quantity) {
        Asset asset = new Asset();
        asset.setUser(user);
        asset.setCoin(coin);
        asset.setQuantity(quantity);
        asset.setBuyPrice(coin.getCurrentPrice());
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAssetById(Long assetId) throws Exception{
        // TODO Auto-generated method stub
        return assetRepository.findById(assetId)
            .orElseThrow(() -> new Exception("asset not found"));
    }

    @Override
    public Asset getAssetByUserIdandId(Long userId, Long assetId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAssetByUserIdandId'");
    }

    @Override
    public List<Asset> getUsersAssets(Long userId) {
        // TODO Auto-generated method stub
        return assetRepository.findByUserId(userId);
    }

    @Override
    public Asset updateAsset(Long assetId, double quantity) throws Exception{
        // TODO Auto-generated method stub
        Asset oldAsset = getAssetById(assetId);
        oldAsset.setQuantity(quantity);
        return assetRepository.save(oldAsset);
    }

    @Override
    public Asset findAssetByUserIdAndCoinId(Long userId, String coinId) {
        // TODO Auto-generated method stub
        return assetRepository.findByUserIdAndCoinId(userId, coinId);
    }


    @Override
    public void deleteAsset(Long assetId) {
        // TODO Auto-generated method stub
        assetRepository.deleteById(assetId);
    }
}
