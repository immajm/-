package cn.lezu.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/3/27
 */

@Data
@TableName("bill")
public class Bill implements Serializable {

    @TableId(value = "bill_id",type = IdType.INPUT)
    private int billId;
    private int walletId;
    private double billMoney;
    private String billType;
    private Date billTime;
    private String billCounterparty;
    private String billNote;
    private String billTransactionType;
}
