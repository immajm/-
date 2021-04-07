package cn.lezu.consumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/3/27
 */
@Data
@TableName("coupon")
public class Coupon implements Serializable {
    private static final long serialVersionUID = 1L;
    private int couponId;
    private int walletId;
    private int storeId;
    private double couponNeedMoney;
    private double couponReduceMoney;
}
