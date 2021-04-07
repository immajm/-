package cn.lezu.consumer.service;

import cn.lezu.consumer.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IAddressService extends IService<Address> {
    public List<Address> addrlist(Integer userId);

}
