package cn.lezu.consumer.controller;

import cn.lezu.consumer.entity.Address;
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
 * @time: 2021/4/3
 */

@Api(tags = "账单明细模块")
@RestController
@RequestMapping("/bill")
@CrossOrigin
public class BillController {
    @Autowired
    IBillService billService;
    @Autowired
    IWalletService walletService;

    @ApiOperation(value = "删除账单明细")
    @PostMapping("/remove/bybillId")
    public boolean remove(@RequestParam(value = "bill_id") Integer billId){
        return billService.removeById(billId);
    }

    @ApiOperation(value = "账单明细全列表")
    @GetMapping("/list")
    public List<Bill> list(@RequestParam(value = "consumer_id") Integer consumerId) {
        int walletId=walletService.getId(consumerId);
        return billService.listbill(walletId);
    }

    @GetMapping("/getWalletId")
    public int getWalletId(@RequestParam(value = "consumer_id") Integer consumerId) {
        return walletService.getId(consumerId);
    }

    @ApiOperation(value = "充值money")
    @PostMapping("/recharge")
    public boolean recharge( @RequestBody  Bill bill){
        double value=bill.getBillMoney();
        int walletid=bill.getWalletId();
        walletService.recharge(walletid,value);
        return billService.save(bill);

    }

    @ApiOperation(value = "花费money")
    @PostMapping("/cost")
    public boolean cost( @RequestBody  Bill bill){
        double value=bill.getBillMoney();
        int walletid=bill.getWalletId();
        if(walletService.getMoney(walletid)-value>=0) {
            walletService.cost(walletid,value);
            return billService.save(bill);
        }
        else {
            return false;
        }


    }


/////////////////////////////////////////////////////一下部分是订单数据库用的，不属于这里////////////////////////////////////////


    //用户确认收货同时商家和骑手产生收益
//    @ApiOperation(value = "用户确认收货同时商家和骑手产生收益")
//    @PostMapping("/user/confirm")
//    public int userconfirmorder(@RequestParam(value = "o_id")String orderId){
//        orderService.userconfirmorder(orderId);
//        orderService.ridermoney(orderId);//骑手收益函数
//        orderService.ridermoney1(orderId);
//        orderService.shopmoney(orderId);//商家收益函数
//        return orderService.shopmoney1(orderId);
//    }

    //用户取消订单
    @ApiOperation(value = "用户取消订单")
    @PostMapping("/user/cancel")
    public int usercancel(@RequestParam(value = "o_id")int orderId){
        billService.usercancel(orderId);
        return 1;//取消成功返回1
    }




    //开始结算但未支付
    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public int createOrder(@RequestParam(value = "shop_id")String shopId,@RequestParam(value = "user_id") String userId){
        billService.createOrder(shopId,userId);
        List<Bill> orders = billService.getOrderList();
        return orders.get(0).getBillId();//返回当前订单号
    }

    //支付完成
    @ApiOperation(value = "确认下单")
    @PostMapping("/done")
    public Bill doneOrder(@RequestParam(value = "o_id") Integer orderId,
                           @RequestParam(value = "user_id") String userId,
                           @RequestParam(value = "address_id") Integer addressId){
        double sum = 0;
        sum = billService.sumMoney(orderId);
        String isVIP = "";
        billService.doneOrder(orderId,addressId,sum);
        isVIP = billService.isVip(userId);
        if(isVIP.equals("是")){
            billService.updateMon(orderId);
        }
        boolean flag = billService.userPay(userId,sum);
        if(flag) billService.dealOrder(orderId);
        String nowStatus =  "";
        nowStatus = billService.findStatus(orderId);
        if(nowStatus.equals("已下单")) return billService.findOrder(orderId);
        else return null;
    }

    @ApiOperation(value = "用户查看正在配送订单")
    @PostMapping("/user/check")
    public List<Bill> deliveryOrder(@RequestParam(value = "user_id") String userId){
        return billService.deliveryOrder(userId);
    }

    //不用设置骑手，这里需要修改
    @ApiOperation(value = "用户确认收货")
    @PostMapping("user/confirm")
    public int userConfirmOrder(@RequestParam(value = "o_id") Integer orderId){
        String nowStatus =  "";
        nowStatus = billService.findStatus(orderId);
        if(nowStatus.equals("正在配送")) return -2;
        else {
//            billService.userConfirm(orderId);//改订单状态
//            billService.ridermoney(orderId);
//            billService.ridermoney1(orderId);//骑手入账
//            billService.shopmoney(orderId);
//            billService.shopmoney1(orderId);//商家入账
            return 1;
        }
    }


    @ApiOperation(value = "用户查看个人订单")
    @GetMapping("/user/list")
    public List<Bill> userOrder(@RequestParam(value = "user_id") String userId){
        return billService.userorder(userId);
    }


    @ApiOperation(value = "用户查看历史订单")
    @PostMapping("user/record")
    public List<Bill> userRecord(@RequestParam(value = "user_id") String userId){
        return billService.userRecord(userId);
    }

}
