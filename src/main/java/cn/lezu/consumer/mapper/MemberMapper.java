package cn.lezu.consumer.mapper;



import cn.lezu.consumer.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public interface MemberMapper extends BaseMapper<Member> {

    @Insert("insert into member(consumer_id) values(#{consumer_id})")
    int openMember(@Param("consumer_id")  Integer consumerId);

    @Update("update member set member_integral=member_integral+#{num} where consumer_id =#{consumer_id} ")
    int addIntegral(@Param("consumer_id") int consumerId, @Param(value = "num") int value);

    @Update("update member set member_integral=member_integral-#{num} where consumer_id =#{consumer_id} ")
    int reduceIntegral(@Param("consumer_id") int consumerId, @Param(value = "num")  int value);

    @Update("update member set member_growth_value=member_growth_value+#{num} where consumer_id =#{consumer_id} ")
    int addgvalue(@Param("consumer_id") int consumerId, @Param(value = "num")  int value);

    @Select("select * from member where consumer_id =#{consumer_id} ")
    Member findMember(@Param("consumer_id")int consumerId);
}
