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
@TableName("address")
public class Address {

    @TableId(value = "address_id",type = IdType.INPUT)
    private int addressId;

    private int consumerId;
    private String addressIphone;
    private String addressCity;
    private String addressRegion;
    private String addressName;
    private String addressDetailed;

}
