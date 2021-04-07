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
@TableName("collect")
public class Collect implements Serializable {

    @TableId(value = "collect_id",type = IdType.INPUT)
    private int collectId;
    private int consumerId;
    private int goodId;
}
