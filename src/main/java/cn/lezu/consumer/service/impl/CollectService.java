package cn.lezu.consumer.service.impl;

import cn.lezu.consumer.entity.Collect;
import cn.lezu.consumer.mapper.CollectMapper;
import cn.lezu.consumer.service.ICollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService extends ServiceImpl<CollectMapper, Collect> implements ICollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public List<Collect> collectList(Integer consumerId) {
        return collectMapper.collectList(consumerId);
    }


}