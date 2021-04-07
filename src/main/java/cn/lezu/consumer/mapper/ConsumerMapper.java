package cn.lezu.consumer.mapper;


import cn.lezu.consumer.entity.Consumer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConsumerMapper extends BaseMapper<Consumer> {

    @Select("select * from consumer where consumer_phone_number =#{consumer_phone_number}")
    Consumer findOneConsumerByTel(@Param("consumer_phone_number") String consumerPhoneNumber);

    @Insert("insert into consumer(consumer_phone_number,consumer_password) values(#{consumer_phone_number},#{consumer_password})")
    public int createConsumer(@Param("consumer_phone_number") String consumerPhoneNumber,@Param("consumer_password")String consumerPassword);

    @Select("select consumer_id from consumer where consumer_phone_number =#{consumer_phone_number}")
    public int getConsumerID(@Param("consumer_phone_number") String consumerTel);

    @Update("update consumer set consumer_is_member = '会员' where consumer_id =#{consumer_id} ")
    public int tobeMember(@Param("consumer_id") int consumerId);

    @Select("select consumer_is_member from consumer where consumer_id=#{consumer_id}")
    String isMember(@Param("consumer_id") int consumerId);
}
