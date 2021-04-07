package cn.lezu.consumer.controller;

import cn.lezu.consumer.entity.Bill;
import cn.lezu.consumer.service.IBillService;
import cn.lezu.consumer.service.IWalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/4/5
 */


@Api(tags = "钱包模块")
@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletController {

    @Autowired
    IWalletService walletService;

    @Autowired
    IBillService billService;

    @ApiOperation(value = "查看余额")
    @GetMapping("/getbalance")
    public double getbalance(@RequestParam(value = "consumer_id") Integer consumerId) {
        return walletService.getbalance(consumerId);
    }

    @ApiOperation(value = "查看钱包积分")
    @GetMapping("/getIntegral")
    public int getIntegral(@RequestParam(value = "consumer_id") Integer consumerId) {
        return walletService.getIntegral(consumerId);
    }


    @ApiOperation(value = "钱包积分增加")
    @PostMapping("/addIntegral")
    public int addIntegral(@RequestParam(value = "consumer_id") int consumerId,@RequestParam(value = "num")  int value){
        return walletService.addIntegral(consumerId,value);

    }



    @ApiOperation(value = "获得walletId")
    @GetMapping("/getId")
    public int getId(@RequestParam(value = "consumer_id") Integer consumerId) {
        return walletService.getId(consumerId);
    }



}
