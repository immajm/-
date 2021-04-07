package cn.lezu.consumer.mapper;



import cn.lezu.consumer.entity.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectMapper extends BaseMapper<Collect> {

    @Select("select * from collect where consumer_id =#{consumer_id}")
    List<Collect> collectList(@Param("consumer_id") Integer consumerId);
}
