package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.request.UserOrderCancelRequest;
import com.CookingMama.dev.domain.request.UserOrderRequest;
import com.CookingMama.dev.domain.response.OrderResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderRepository {
    Integer addOrders(List<UserOrderRequest> requests);
    Integer cancelOrders(String orderNumber, Integer userId);
    List<OrderResponse> myOrders(Integer userId);
}
