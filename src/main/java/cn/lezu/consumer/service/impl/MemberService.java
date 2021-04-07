package cn.lezu.consumer.service.impl;

import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.entity.Member;
import cn.lezu.consumer.mapper.MemberMapper;
import cn.lezu.consumer.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MemberService extends ServiceImpl<MemberMapper, Member> implements IMemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public int openMember(Integer consumerId) {
        return memberMapper.openMember(consumerId);
    }

    @Override
    public int addIntegral(int consumerId, int value) {
        return memberMapper.addIntegral(consumerId,value);
    }

    @Override
    public int reduceIntegral(int consumerId, int value) {
        return memberMapper.reduceIntegral(consumerId,value);
    }

    @Override
    public int addgvalue(int consumerId, int value) {
        return memberMapper.addgvalue(consumerId,value);
    }

    @Override
    public Member findMember(int consumerId) {
        return memberMapper.findMember(consumerId);
    }


}