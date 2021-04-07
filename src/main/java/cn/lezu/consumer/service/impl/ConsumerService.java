package cn.lezu.consumer.service.impl;

import cn.lezu.consumer.entity.Consumer;
import cn.lezu.consumer.mapper.ConsumerMapper;
import cn.lezu.consumer.service.IConsumerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService extends ServiceImpl<ConsumerMapper, Consumer> implements IConsumerService {
    @Autowired
    ConsumerMapper consumerMapper;

    @Override
    public Consumer findOneConsumerByTel(String consumerTel) {
        return consumerMapper.findOneConsumerByTel(consumerTel);
    }

    public int createConsumer(String consumerPhoneNumber,String consumerPassword){
        return consumerMapper.createConsumer(consumerPhoneNumber,consumerPassword);
    }

    @Override
    public int getConsumerID(String consumerTel) {
        return consumerMapper.getConsumerID(consumerTel);
    }

    @Override
    public int tobeMember(int consumerId) {
        return consumerMapper.tobeMember(consumerId);
    }

    @Override
    public String isMember(int consumerId) {
        return consumerMapper.isMember(consumerId);
    }


}
