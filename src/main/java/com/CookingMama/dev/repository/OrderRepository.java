package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.request.UserOrderRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderRepository {
    Integer addOrders(List<UserOrderRequest> requests);
}
