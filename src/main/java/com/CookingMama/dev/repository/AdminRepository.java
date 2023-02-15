package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.AdminDTO;
import com.CookingMama.dev.domain.request.AdminLoginRequest;
import com.CookingMama.dev.domain.request.AdminSignUpRequest;
import com.CookingMama.dev.domain.request.AdminUpdateItemRequest;
import com.CookingMama.dev.domain.response.AdminItemResponse;
import com.CookingMama.dev.domain.response.AdminResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminRepository {
    Integer adminSignUp(AdminSignUpRequest request);
    AdminDTO adminLogin(AdminLoginRequest request);

    List<AdminItemResponse> itemList(Integer adminId);
    List<AdminItemResponse> itemDetail(Integer adminId, Integer itemId);

    Integer updateItem(AdminUpdateItemRequest request);
}
