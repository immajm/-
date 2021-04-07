package cn.lezu.consumer.controller;

import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.entity.Collect;
import cn.lezu.consumer.service.IAddressService;
import cn.lezu.consumer.service.ICollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/4/5
 */
@Api(tags = "收藏模块")
@RestController
@RequestMapping("/collect")
@CrossOrigin
public class CollectController {
    @Autowired
    ICollectService collectService;

    //用户添加地址或修改地址
    @ApiOperation(value = "添加收藏")
    @PostMapping("/save")
    public boolean save(@RequestBody Collect collect){
        return collectService.save(collect);
    }

    @ApiOperation(value = "取消收藏")
    @PostMapping("/remove/bycollectId")
    public boolean remove(@RequestParam(value = "collect_id") Integer collectId){
        return collectService.removeById(collectId);
    }

    @ApiOperation(value = "查找该用户全部收藏")
    @PostMapping("/list")
    public List<Collect> list(@RequestParam(value = "consumer_id") Integer consumerId){
        return collectService.collectList(consumerId);
    }

}
