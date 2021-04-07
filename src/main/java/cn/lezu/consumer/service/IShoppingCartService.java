package cn.lezu.consumer.service;

import cn.lezu.consumer.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IShoppingCartService extends IService<ShoppingCart> {
    //生成id
    public List<ShoppingCart> getAllCartList();

    //添加
    public ShoppingCart findproduct(Integer shoppingCartId, Integer goodId);
    public int insertCart(Integer shoppingCartId,Integer consumerId,Integer goodId);
    public int addCart(Integer shoppingCartId,Integer goodId);

    //删除
    public int deleteOneProduct(Integer shoppingCartId,Integer goodId);
    public int deleteAllProduct(Integer shoppingCartId,Integer goodId);

    //查看
    public List<ShoppingCart> userCart(Integer shoppingCartId);


    int getGoodNums(Integer shoppingCartId, Integer goodId);


//    //生成订单
//    public boolean createorder(Integer orderId);
//    public boolean xiadan(String userId,Integer addressId,Integer orderId);


}
