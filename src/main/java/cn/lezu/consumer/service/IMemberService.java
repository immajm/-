package cn.lezu.consumer.service;

import cn.lezu.consumer.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IMemberService extends IService<Member> {

    public int openMember(Integer consumerId);


    int addIntegral(int consumerId, int value);

    int reduceIntegral(int consumerId, int value);

    int addgvalue(int consumerId, int value);


    Member findMember(int consumerId);
}
