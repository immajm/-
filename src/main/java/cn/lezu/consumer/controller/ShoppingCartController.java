package cn.lezu.consumer.controller;

import cn.lezu.consumer.entity.Bill;
import cn.lezu.consumer.entity.ShoppingCart;
import cn.lezu.consumer.service.IConsumerService;
import cn.lezu.consumer.service.IShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/4/3
 */

@Api(tags = "购物车模块")
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class ShoppingCartController {
    @Autowired
    IShoppingCartService shoppingCartService;
    @Autowired
    IConsumerService consumerService;


    @ApiOperation(value = "创建购物车编号")
    @PostMapping("/create")
    public int createOrder(){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getAllCartList();
        return shoppingCarts.get(0).getShoppingCartId()+1;//返回当前订单号+1
    }

    //存在+1，否则创建
    @ApiOperation(value = "用户加入购物车")
    @PostMapping("/add")
    public int addCart(@RequestParam(value = "shopping_cart_id") Integer shoppingCartId,
                       @RequestParam(value = "consumer_id") int consumerId,
                       @RequestParam(value = "good_id") Integer goodId){
        ShoppingCart shoppingCart = shoppingCartService.findproduct(shoppingCartId,goodId);
        if (shoppingCart==null){
            shoppingCartService.insertCart(shoppingCartId,consumerId,goodId);
        }
        else{
            shoppingCartService.addCart(shoppingCartId,goodId);
        }
        return 1;
    }

    //>1 减一，否则删去该商品
    @ApiOperation(value = "用户购物车中的商品-1")
    @PostMapping("/delete/oneproduct")
    public int deleteOne(@RequestParam(value = "shopping_cart_id") Integer shoppingCartId,
                          @RequestParam(value = "good_id") Integer goodId){
        ShoppingCart shoppingCart = shoppingCartService.findproduct(shoppingCartId,goodId);
        if(shoppingCart==null) return -1;
        else{
            int nums=shoppingCartService.getGoodNums(shoppingCartId,goodId);
            if(nums>1){
                shoppingCartService.deleteOneProduct(shoppingCartId,goodId);
            }else{
                shoppingCartService.deleteAllProduct(shoppingCartId,goodId);
            }
            //直接return 1 没有考虑事务
            return 1;
        }
    }

    @ApiOperation(value = "删除购物车中的一种商品")
    @PostMapping("/delete/allproduct")
    public int deleteAll(@RequestParam(value = "shopping_cart_id") Integer shoppingCartId,
                          @RequestParam(value = "good_id") Integer goodId){
        ShoppingCart shoppingCart = shoppingCartService.findproduct(shoppingCartId,goodId);
        if(shoppingCart==null) return -1;
        else {
            shoppingCartService.deleteAllProduct(shoppingCartId,goodId);
            return 1;
        }
    }


    @ApiOperation(value = "用户查看购物车")
    @GetMapping("/list")
    public List<ShoppingCart> userCart(@RequestParam(value = "shopping_cart_id") Integer shoppingCartId){
        return shoppingCartService.userCart(shoppingCartId);
    }

    //这个还有点问题,未写
//    @ApiOperation(value = "用户下单")
//    @PostMapping("/order")
//    public boolean findPrice(@RequestParam(value = "o_id") Integer orderId, @RequestParam(value = "user_id") String userId,
//                             @RequestParam(value = "address_id") Integer addressId){
//        shoppingCartService.createorder(orderId);
//        return shoppingCartService.xiadan(userId,addressId,orderId);
//    }


}
