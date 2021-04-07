package cn.lezu.consumer.service;

import cn.lezu.consumer.entity.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IConsumerService extends IService<Consumer> {
    public Consumer findOneConsumerByTel(String consumerTel);

    public int createConsumer(String consumerPhoneNumber,String consumerPassword);

    public int getConsumerID(String consumerTel);

    public int tobeMember(int consumerId);

    String isMember(int consumerId);
}
