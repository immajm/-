package cn.lezu.consumer.mapper;

import cn.lezu.consumer.entity.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    //生成购物车id
    @Select("select shopping_cart_id from shopping_cart order by shopping_cart_id DESC")
    public List<ShoppingCart> getAllCartList();

    //添加
    @Select("select * from shopping_cart where shopping_cart_id=#{shopping_cart_id} and good_id=#{good_id}")
    public ShoppingCart findproduct(@Param("shopping_cart_id") Integer shoppingCartId,@Param("good_id") Integer goodId);

    @Insert("insert into shopping_cart(shopping_cart_id,consumer_id,good_id,good_number) values(#{shopping_cart_id},#{consumer_id},#{good_id},1)")
    public int insertCart(@Param("shopping_cart_id") Integer shoppingCartId,@Param("consumer_id") Integer consumerId,@Param("good_id") Integer goodId);

    @Update("update shopping_cart set good_number=good_number+1 where shopping_cart_id=#{shopping_cart_id} and good_id=#{good_id}")
    public int addCart(@Param("shopping_cart_id") Integer shoppingCartId,@Param("good_id") Integer goodId);


    //删除
    @Update("update shopping_cart set good_number=good_number -1 where shopping_cart_id=#{shopping_cart_id} and good_id=#{good_id}")
    public int deleteOneProduct(@Param("shopping_cart_id") Integer shoppingCartId,@Param("good_id") Integer goodId);

    @Delete("delete from shopping_cart where shopping_cart_id=#{shopping_cart_id} and good_id=#{good_id}")
    public int deleteAllProduct(@Param("shopping_cart_id") Integer shoppingCartId,@Param("good_id") Integer goodId);


    //查看
    @Select("select shopping_cart_id,consumer_id,good_id,good_number from shopping_cart where shopping_cart_id=#{shopping_cart_id} ")
    public List<ShoppingCart> userCart(@Param("shopping_cart_id") Integer shoppingCartId);

    //获取数量
    @Select("select good_number from shopping_cart where shopping_cart_id=#{shopping_cart_id} and good_id=#{good_id} ")
    int getGoodNums(@Param("shopping_cart_id")Integer shoppingCartId, @Param("good_id")Integer goodId);


//    //下单
//    @Insert("insert into orders(o_id,shop_id,row,mon)\n" +
//            "SELECT orderdetail.o_id,shop_id,final_price,final_price\n" +
//            "from orderdetail,products,producttype\n" +
//            "where o_id=#{o_id} and products.p_id=orderdetail.product_id and products.type_id=producttype.type_id")
//    public boolean createorder(@Param("o_id") Integer orderId);
//
//    @Update("update orders set order_status='已下单',user_id=#{user_id},address_id=#{address_id} where o_id=#{o_id}")
//    public boolean xiadan(@Param("user_id") String userId,@Param("address_id")Integer addressId,@Param("o_id")Integer orderId);


}
