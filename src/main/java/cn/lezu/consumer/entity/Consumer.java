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
@TableName("consumer")
public class Consumer implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "consumer_id",type = IdType.INPUT)
    private int consumerId;
    private String consumerName;
    private String consumerPhoneNumber;
    private String consumerIsMember;
    private String consumerPassword;
    private Date memberEndTime;
    private String consumerIsIdentity;
    private Date consumerRegistrationTime;
    private String consumerHeadImage;
}
