package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.AdminDTO;
import com.CookingMama.dev.domain.request.AdminLoginRequest;
import com.CookingMama.dev.domain.request.AdminSignUpRequest;
import com.CookingMama.dev.domain.response.AdminResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminRepository {
    Integer adminSignUp(AdminSignUpRequest request);
    AdminDTO adminLogin(AdminLoginRequest request);
}
