package cn.lezu.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/3/27
 */

@Data
@TableName("wallet")
public class Wallet implements Serializable {

    @TableId(value = "wallet_id",type = IdType.INPUT)
    private int walletId;
    private int consumerId;
    private double walletMoney;
    private int walletIntegral;

}
