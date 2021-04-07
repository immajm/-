package cn.lezu.consumer.service.impl;

import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.mapper.AddressMapper;
import cn.lezu.consumer.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> implements IAddressService {
    @Autowired
    AddressMapper addressMapper;

    public List<Address> addrlist(Integer consumerId){
        return addressMapper.addrlist(consumerId);
    }

}