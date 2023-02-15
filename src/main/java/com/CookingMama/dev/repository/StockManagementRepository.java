package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.StockUpdateRequest;
import com.CookingMama.dev.domain.request.UserOrderCancelRequest;
import com.CookingMama.dev.domain.response.StockManagementResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StockManagementRepository {
    List<StockManagementResponse> stockManagement(Integer adminId);

    Integer stockUpdate(StockUpdateRequest request);
    Integer userAddOrder(Integer itemCount, Integer itemId);
    Integer userCancelOrder(UserOrderCancelRequest request);
}
