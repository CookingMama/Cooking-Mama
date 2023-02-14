package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.AdminDTO;
import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.AdminLoginRequest;
import com.CookingMama.dev.domain.request.AdminSignUpRequest;
import com.CookingMama.dev.domain.response.AdminResponse;
import com.CookingMama.dev.domain.response.StockManagementResponse;
import com.CookingMama.dev.repository.AdminRepository;
import com.CookingMama.dev.security.SecurityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final SecurityService securityService;

    public AdminResponse adminLogin(AdminLoginRequest request){
        AdminDTO loginDTO = adminRepository.adminLogin(request);
        if (loginDTO.getAdminEmail() != null){
            String token = securityService.createAdminToken(loginDTO);
            return new AdminResponse(
                    loginDTO.getAdminEmail(),
                    token
            );
        }
        return null;
    }

    public AdminResponse adminSignUp(AdminSignUpRequest request){
        Integer insertId = adminRepository.adminSignUp(request);
        if(insertId != null){
            return adminLogin(new AdminLoginRequest(request.getAdminEmail(), request.getAdminPw()));
        }
        return null;
    }
}
