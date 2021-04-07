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
@TableName("member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    private int memberId;
    private int consumerId;
    private int memberGrowthValue;
    private int memberIntegral;

}
