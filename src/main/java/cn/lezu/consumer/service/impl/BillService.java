package cn.lezu.consumer.service.impl;

import cn.lezu.consumer.entity.Address;
import cn.lezu.consumer.entity.Bill;
import cn.lezu.consumer.mapper.BillMapper;
import cn.lezu.consumer.service.IBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService extends ServiceImpl<BillMapper, Bill> implements IBillService {
    @Autowired
    BillMapper billMapper;

    @Override
    public List<Bill> listbill(Integer walletId) {
//        List<Bill> res=billMapper.listbill(walletId);
//        System.out.println("service");
//        for (int i = 0; i <res.size() ; i++) {
//            System.out.println(res.get(i));
//        }
        return billMapper.listbill(walletId);
    }


/////////////////////////////////////////////////////一下部分是订单数据库用的，不属于这里////////////////////////////////////////

    public int userconfirmorder(String orderId){
        return billMapper.userconfirmorder(orderId);
    }
    public int usercancel(int orderId){
        return billMapper.usercancel(orderId);
    }
    public List<Bill> userorder(String userId){
        return billMapper.userorder(userId);
    }

    public int createOrder(String shopId, String userId){
        return billMapper.createOrder(shopId,userId);
    }
    public List<Bill> getOrderList(){
        return billMapper.getOrderList();
    }
    public boolean doneOrder(Integer orderId, Integer addressId,double sum){
        return billMapper.doneOrder(orderId,addressId,sum);
    }
    public double sumMoney(Integer orderId){
        return billMapper.sumMoney(orderId);
    }

    public String isVip(String userId){
        return billMapper.isVip(userId);
    }

    public boolean updateMon(Integer orderId){
        return billMapper.updateMon(orderId);
    }

    public boolean userPay(String userId,double sum){
        return billMapper.userPay(userId,sum);
    }

    public Bill findOrder(Integer orderId){
        return billMapper.findOrder(orderId);
    }

    public String findStatus(Integer orderId){
        return billMapper.findStatus(orderId);
    }

    public void dealOrder(Integer orderId){
        billMapper.dealOrder(orderId);
    }

    public List<Bill> deliveryOrder(String userId){
        return billMapper.deliveryOrder(userId);
    }

    public void userConfirm(Integer orderId){
        billMapper.userConfirm(orderId);
    }

    public List<Bill> userRecord(String userId){
        return billMapper.userRecord(userId);
    }


}