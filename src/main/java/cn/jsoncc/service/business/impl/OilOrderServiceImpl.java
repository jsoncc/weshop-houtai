package cn.jsoncc.service.business.impl;

import cn.jsoncc.bean.OilOrder;
import cn.jsoncc.dao.business.OilDao;
import cn.jsoncc.dao.business.OilOrderDao;
import cn.jsoncc.service.business.OilOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: JsonCC
 * Date: 2021/7/9 14:30
 * Email:896415482@qq.com
 */
@Service("/oilOrderService")
public class OilOrderServiceImpl implements OilOrderService {

    @Autowired
    OilOrderDao oilOrderDao;

    @Autowired
    OilDao oilDao;

    //获取当前最大订单号
    private String currentMaxOrderNum;

    @Transactional
    @Override
    public int save(OilOrder oilOrder) {
        //查询油站的油卡余额
        double money = oilDao.queryOilOrderBalance(oilOrder.getOilid());
        if (oilOrder.getPayment()>money){
            return 2;//油站油卡余额不足
        }
        //余额充足的时候，就生成新的订单
        String orderNum = getNewOrderNum();
        oilOrder.setOrdernum(orderNum);

        //生成订单,设置预支付交易会话标识
        oilOrder.setPrepay_id("订单详细");

        //保存订单
        int rs =oilOrderDao.save(oilOrder);
        if (rs==1){
            return oilDao.updateOilOrderBalance(oilOrder);
        }

        return rs;
    }

    //获取新生成的订单号
    String getNewOrderNum(){
        //获取下单时间
        String ym = getYm();

        //先判断新订单是否存在
        if (null == currentMaxOrderNum){
            //查询当月最大订单号
            currentMaxOrderNum=oilOrderDao.queryMaxOilOrderNum();
            if (null==currentMaxOrderNum){//如果当月没有订单
                //说明到了一个新的月，就重新开始，生成新的第一笔订单
                this.currentMaxOrderNum = "dd"+ym+"0001";
            }else {//当月有订单的话，就接着往下再生成一个订单
                this.currentMaxOrderNum = generateNextNum(currentMaxOrderNum);
            }
            return this.currentMaxOrderNum;
        }
        //判断当前下单时间与订单号是否是同一个月
        if (currentMaxOrderNum.substring(2,8).equals(ym)){//通过截取获得订单时间，然后比较
            //如果下单时间与订单时间是同一个月，就得到该订单号
            this.currentMaxOrderNum = generateNextNum(currentMaxOrderNum);
        }else {
            this.currentMaxOrderNum = "dd"+ym+"0001";
        }
        return this.currentMaxOrderNum;
    }

    //获得订单号
    String generateNextNum(String ordernum){
        String num=ordernum.substring(8);
        int tmp=Integer.parseInt(num);
        tmp+=1;
        return ordernum.substring(0, 8)+String.format("%04d", tmp);
    }

    //获取时间
    String getYm(){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }
}
