package cn.lezu.consumer.service.impl;

import cn.lezu.consumer.entity.Wallet;
import cn.lezu.consumer.mapper.WalletMapper;
import cn.lezu.consumer.service.IWalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService extends ServiceImpl<WalletMapper, Wallet> implements IWalletService {
    @Autowired
    WalletMapper walletMapper;

    @Override
    public int create(int consumerID) {
        return walletMapper.create(consumerID);
    }

    @Override
    public double getbalance(Integer consumerId) {
        return walletMapper.getbalance(consumerId);
    }

    @Override
    public int getIntegral(Integer consumerId) {
        return walletMapper.getIntegral(consumerId);
    }

    @Override
    public int recharge(int walletId, double value) {
        return walletMapper.recharge(walletId,value);
    }

    @Override
    public int cost(int walletId, double value) {
        return walletMapper.cost(walletId,value);
    }

    @Override
    public int getId(Integer consumerId) {
        return walletMapper.getId(consumerId);
    }

    @Override
    public int addIntegral(int consumerId, int value) {
        return walletMapper.addIntegral(consumerId,value);
    }

    @Override
    public double getMoney(int walletid) {
        return walletMapper.getMoney(walletid);
    }

}