package cn.lezu.consumer.controller;


import cn.lezu.consumer.entity.Consumer;
import cn.lezu.consumer.service.IConsumerService;
import cn.lezu.consumer.service.IWalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户模块")
@RestController
@RequestMapping("/cus")
@CrossOrigin
public class ConsumerController {

    @Autowired
    IConsumerService consumerService;

    @Autowired
    IWalletService walletService;

    //用户注册+修改个人信息
    @ApiOperation(value = "新增用户")
    @PostMapping("/save")
    public int save(@RequestParam(value = "consumer_phone_number") String consumerTel,
                    @RequestParam(value = "consumer_password")String consumerPwd){
        //存在该tel不传入
        //不存在作新增操作
        //电话号码格式不对，还未校验报错
        Consumer oneConsumer = consumerService.findOneConsumerByTel(consumerTel);
        System.out.println(oneConsumer);
        if(oneConsumer!=null) return -1;//已存在用户
        //添加用户
        //根据id生成钱包
        if(consumerService.createConsumer(consumerTel,consumerPwd)==1&&
                walletService.create(consumerService.getConsumerID(consumerTel))==1){
            return 1;
        }
        else return 0;

    }

    //用户登陆
    //返回值
    //-1用户不存在
    //-2密码错误
    //1登陆成功
    @ApiOperation(value = "用户通过手机号密码登录")
    @PostMapping("/login/byTel")
    public int loginbyTel(@RequestParam(value = "consumer_phone_number") String consumerTel,
                          @RequestParam(value = "consumer_password") String consumerPwd){
        Consumer oneConsumer = consumerService.findOneConsumerByTel(consumerTel);
        if(oneConsumer==null) return -1;//用户手机号不存在
        else{
            if(oneConsumer.getConsumerPassword().equals(consumerPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }

    //用户获得id
    @ApiOperation(value = "用户通过手机号获得id")
    @GetMapping("/getID")
    public int getConsumerID(@RequestParam(value = "consumer_phone_number") String consumerTel ){
        return consumerService.getConsumerID(consumerTel);
    }


    //管理员删除用户
    @ApiOperation(value = "删除相关数据")
    @PostMapping("/remove/byCusId")
    public boolean remove(@RequestParam(value = "consumer_id") int consumerId){
        return consumerService.removeById(consumerId);
    }


    //管理员查看用户列表
    @ApiOperation(value = "用户全列表")
    @GetMapping("/list")
    public List<Consumer> list(){
        return consumerService.list();
    }

}
