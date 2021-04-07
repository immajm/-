package cn.lezu.consumer.mapper;



import cn.lezu.consumer.entity.Wallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WalletMapper extends BaseMapper<Wallet> {
    @Insert("insert into wallet(consumer_id) values(#{consumer_id})")
    int create(@Param("consumer_id") int consumerID);

    @Select("select wallet_money from wallet where consumer_id=(#{consumer_id})")
    double getbalance(@Param("consumer_id") int consumerID);

    @Select("select wallet_integral from wallet where consumer_id=(#{consumer_id})")
    int getIntegral(@Param("consumer_id") int consumerID);

    @Update("update wallet set wallet_money=wallet_money+#{num} where wallet_id =#{wallet_id} ")
    int recharge(@Param("wallet_id")int walletId, @Param("num") double value);

    @Update("update wallet set wallet_money=wallet_money-#{num} where wallet_id =#{wallet_id} ")
    int cost(@Param("wallet_id")int walletId, @Param("num") double value);

    @Select("select wallet_id from wallet where consumer_id =#{consumer_id} ")
    int getId(@Param("consumer_id")Integer consumerId);

    @Update("update wallet set wallet_integral=wallet_integral+#{num} where consumer_id =#{consumer_id} ")
    int addIntegral(@Param("consumer_id")int consumerId, @Param("num") double value);

    @Select("select wallet_money from wallet where wallet_id =#{wallet_id}")
    double getMoney(@Param("wallet_id") int walletid);
}
