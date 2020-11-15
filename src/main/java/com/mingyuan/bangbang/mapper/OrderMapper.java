package com.mingyuan.bangbang.mapper;

import com.mingyuan.bangbang.pojo.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    public void publishOrder(@Param("orderInfo")OrderInfo orderInfo);
    public List<OrderInfo> getOrderInfos();
    public OrderInfo getOrderInfo(@Param("oId") int oId);
    public List<OrderInfo> getMyPublishOrder(@Param("unionid") String unionid);
    public List<OrderInfo> getMyReceiveOrder(@Param("unionid") String unionid);
    public void cCancelOrder(int OId);
    public int updateOrder(@Param("orderInfo") OrderInfo orderInfo);
    public void deleteOrder(@Param("oId")int oId);

}
