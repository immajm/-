package cn.lezu.consumer.service.impl;


import cn.lezu.consumer.entity.ShoppingCart;
import cn.lezu.consumer.mapper.ShoppingCartMapper;
import cn.lezu.consumer.service.IShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements IShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    //生成id
    public List<ShoppingCart> getAllCartList() {
        return shoppingCartMapper.getAllCartList();
    }

    //添加
    public ShoppingCart findproduct(Integer shoppingCartId, Integer goodId){
        return shoppingCartMapper.findproduct(shoppingCartId,goodId);
    }

    public int insertCart(Integer shoppingCartId,Integer consumerId,Integer goodId){
        return shoppingCartMapper.insertCart(shoppingCartId,consumerId,goodId);
    }

    public int addCart(Integer shoppingCartId,Integer goodId){
        return shoppingCartMapper.addCart(shoppingCartId,goodId);
    }

    //删除
    public int deleteOneProduct(Integer shoppingCartId,Integer goodId){
        return shoppingCartMapper.deleteOneProduct(shoppingCartId,goodId);
    }

    public int deleteAllProduct(Integer shoppingCartId,Integer goodId){
        return shoppingCartMapper.deleteAllProduct(shoppingCartId,goodId);
    }


    //查看
    public List<ShoppingCart> userCart(Integer shoppingCartId){
        return shoppingCartMapper.userCart(shoppingCartId);
    }


    @Override
    public int getGoodNums(Integer shoppingCartId, Integer goodId) {
        return shoppingCartMapper.getGoodNums(shoppingCartId,goodId);
    }


//    //生成订单
//    public boolean createorder(Integer orderId){
//        return shoppingCartMapper.createorder(orderId);
//    }
//
//    public boolean xiadan(String userId,Integer addressId,Integer orderId){
//        return shoppingCartMapper.xiadan(userId,addressId,orderId);
//    }




}
