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
@TableName("shoppingcart")
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;
    private int shoppingCartId;
    private int consumerId;
    private int goodId;
    private int goodNumber;
}
