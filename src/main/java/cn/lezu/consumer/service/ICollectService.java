package cn.lezu.consumer.service;

import cn.lezu.consumer.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ICollectService extends IService<Collect> {

    public List<Collect> collectList(Integer consumerId);
}
