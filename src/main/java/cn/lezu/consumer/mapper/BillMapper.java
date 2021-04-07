package cn.lezu.consumer.mapper;

import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.entity.Bill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface BillMapper extends BaseMapper<Bill> {


    @Select("select * from bill where wallet_id =#{wallet_id} ")
    List<Bill> listbill(@Param("wallet_id") Integer walletId);


/////////////////////////////////////////////////////一下部分是订单数据库用的，不属于这里////////////////////////////////////////

    @Update("update orders set order_status='确认收货' where o_id=#{o_id} and order_status='正在配送'")
    public int userconfirmorder(@Param("o_id") String orderId);

    @Update("update orders set order_status='已取消' where o_id=#{o_id} and order_status='已下单'")
    public int usercancel(@Param("o_id") Integer orderId);

    @Select("select * from orders where user_id=#{user_id}")
    public List<Bill> userorder(@Param("user_id") String userId);

    @Insert("insert into orders(user_id,shop_id,order_status) values(#{user_id},#{shop_id},'正在点单')")
    public int createOrder(@Param("shop_id") String shopId, @Param("user_id") String userId);

    @Select("select * from orders order by o_id DESC")
    public List<Bill> getOrderList();

    @Update("update orders set address_id=#{address_id},order_time=now(),row=#{sum},mon=#{sum} where o_id=#{o_id}")
    public boolean doneOrder(@Param("o_id") Integer orderId, @Param("address_id") Integer addressId, double sum);

    @Select("select sum(final_price) from orderdetail where o_id=#{o_id}")
    public double sumMoney(@Param("o_id") Integer orderId);

    @Select("select is_vip from users where user_id=#{user_id}")
    public String isVip(@Param("user_id") String userId);

    @Update("update orders set mon=mon*0.9 where o_id=#{o_id}")
    public boolean updateMon(@Param("o_id") Integer orderId);

    @Update("update users set user_balance=user_balance-#{sum} where user_id=#{user_id} and user_balance>=#{sum}")
    public boolean userPay(@Param("user_id") String userId, double sum);

    @Select("select a.o_id,a.order_time,a.user_id,c.shop_name,b.linkman,b.province,b.city,b.region,b.address,b.tel,a.mon\n" +
            "from orders a, addrinfo b,shop c\n" +
            "where a.o_id=#{o_id} and a.address_id=b.address_id and c.shop_id=a.shop_id")
    public Bill findOrder(@Param("o_id") Integer orderId);

    @Select("select order_status from orders where o_id=#{o_id}")
    public String findStatus(@Param("o_id") Integer orderId);

    @Update("update orders set order_status='已下单' where o_id=#{o_id}")
    public void dealOrder(@Param("o_id") Integer orderId);

    @Select("select * from orders where user_id=#{user_id} and order_status='正在配送' or order_status='已送达'")
    public List<Bill> deliveryOrder(@Param("user_id") String userId);

    @Update("update orders set order_status='确认收货' where o_id=#{o_id}")
    public void userConfirm(@Param("o_id") Integer orderId);

    @Select("select * from orders where user_id=#{user_id} and order_status='确认收货' order by order_time desc")
    public List<Bill> userRecord(@Param("user_id") String userId);

}
