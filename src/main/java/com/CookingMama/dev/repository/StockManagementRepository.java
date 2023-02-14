package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.StockUpdateRequest;
import com.CookingMama.dev.domain.response.StockManagementResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StockManagementRepository {
    List<Items> stockManagement(Integer adminId);

    Integer stockUpdate(StockUpdateRequest request);
}
