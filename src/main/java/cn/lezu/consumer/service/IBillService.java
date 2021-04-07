package cn.lezu.consumer.service;

import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public interface IBillService extends IService<Bill> {

    public List<Bill> listbill(Integer walletId);


/////////////////////////////////////////////////////一下部分是订单数据库用的，不属于这里////////////////////////////////////////

    public int userconfirmorder(String orderId);

    public int usercancel(int orderId);

    public List<Bill> userorder(String userId);

    public int createOrder(String shopId, String userId);

    public List<Bill> getOrderList();

    public boolean doneOrder(Integer orderId,Integer addressId,double sum);

    public double sumMoney(Integer orderId);

    public String isVip(String userId);

    public boolean updateMon(Integer orderId);

    public boolean userPay(String userId,double sum);

    public Bill findOrder(Integer orderId);

    public String findStatus(Integer orderId);

    public void dealOrder(Integer orderId);

    public List<Bill> deliveryOrder(String userId);

    public void userConfirm(Integer orderId);

    public List<Bill> userRecord(String userId);


}
