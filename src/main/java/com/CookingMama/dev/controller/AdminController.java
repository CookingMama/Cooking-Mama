package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.dto.AdminDTO;
import com.CookingMama.dev.domain.request.AdminLoginRequest;
import com.CookingMama.dev.domain.request.AdminSignUpRequest;
import com.CookingMama.dev.domain.response.AdminResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class AdminController {
    private final AdminService adminService;
    private final SecurityService securityService;

    @PostMapping("/signup")
    public AdminResponse adminSignUp(@RequestBody AdminSignUpRequest request){
        return adminService.adminSignUp(request);
    }

    @PostMapping("/login")
    public AdminResponse adminLogin(@RequestBody AdminLoginRequest request){
        return adminService.adminLogin(request);
    }
}
