package cn.lezu.consumer.mapper;


import cn.lezu.consumer.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressMapper extends BaseMapper<Address> {
    @Select("select * from address where consumer_id =#{consumer_id}")
    List<Address> addrlist(@Param("consumer_id") Integer consumerId);
}
