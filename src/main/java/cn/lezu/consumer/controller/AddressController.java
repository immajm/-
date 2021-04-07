package cn.lezu.consumer.controller;


import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.service.IAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户地址模块")
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    IAddressService addressService;

    //用户添加地址或修改地址
    @ApiOperation(value = "用户添加或修改地址")
    @PostMapping("/save")
    public boolean save(@RequestBody Address address){
        return addressService.saveOrUpdate(address);
    }

    @ApiOperation(value = "用户删除地址")
    @PostMapping("/remove/byaddressId")
    public boolean remove(@RequestParam(value = "address_id") Integer addressId){
        return addressService.removeById(addressId);
    }

    @ApiOperation(value = "用户地址全列表")
    @GetMapping("/list")
    public List<Address> list(@RequestParam(value = "consumer_id") Integer consumerId) {
        return addressService.addrlist(consumerId);
    }
}