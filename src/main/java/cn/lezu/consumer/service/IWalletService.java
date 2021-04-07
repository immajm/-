package cn.lezu.consumer.service;


import cn.lezu.consumer.entity.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IWalletService extends IService<Wallet> {


    int create(int consumerID);

    double getbalance(Integer consumerId);

    int getIntegral(Integer consumerId);

    int recharge(int walletId, double value);

    int cost(int walletId, double value);

    int getId(Integer consumerId);

    int addIntegral(int consumerId, int value);

    double getMoney(int walletid);
}
