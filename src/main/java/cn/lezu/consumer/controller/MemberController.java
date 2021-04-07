package cn.lezu.consumer.controller;

import cn.lezu.consumer.entity.Member;
import cn.lezu.consumer.service.IConsumerService;
import cn.lezu.consumer.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/4/5
 */
@Api(tags = "会员模块")
@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {

    @Autowired
    IMemberService memberService;

    @Autowired
    IConsumerService consumerService;

    //用户添加地址或修改地址
    //-1 开通会员失败
    //0 consumer中修该会员失败
    //1 成功
    //2 已经是会员
    @ApiOperation(value = "开通会员")
    @PostMapping("/open")
    public int openMember(@RequestParam(value = "consumer_id") int consumerId){
        //查询是否已经是会员
        if(memberService.findMember(consumerId)!=null) {
            return 2;
        }
//        if(consumerService.isMember(consumerId).equals("会员")) {
//            return 2;
//        }
        //否则开通
        if(memberService.openMember(consumerId)==1){
            return consumerService.tobeMember(consumerId);
        }
        else return -1;
    }


    @ApiOperation(value = "增加积分")
    @PostMapping("/addIntegral")
    public int addIntegral(@RequestParam(value = "consumer_id") int consumerId,@RequestParam(value = "num") int value){
        return memberService.addIntegral(consumerId,value);

    }

    @ApiOperation(value = "减少（使用）积分")
    @PostMapping("/reduceIntegral")
    public int reduceIntegral(@RequestParam(value = "consumer_id") int consumerId,@RequestParam(value = "num")  int value){
        return memberService.reduceIntegral(consumerId,value);

    }

    @ApiOperation(value = "增加成长值")
    @PostMapping("/addgvalue")
    public int addgvalue(@RequestParam(value = "consumer_id") int consumerId,@RequestParam(value = "num")  int value){
        return memberService.addgvalue(consumerId,value);
    }


}
