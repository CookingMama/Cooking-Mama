package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.dto.AdminDTO;
import com.CookingMama.dev.domain.request.AdminLoginRequest;
import com.CookingMama.dev.domain.request.AdminSignUpRequest;
import com.CookingMama.dev.domain.request.AdminUpdateItemRequest;
import com.CookingMama.dev.domain.response.AdminItemResponse;
import com.CookingMama.dev.domain.response.AdminResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/itemlist")
    public List<AdminItemResponse> itemList(){
        return adminService.itemList();
    }

    @GetMapping("/itemdetail/{itemId}")
    public List<AdminItemResponse> itemDetail(@PathVariable("itemId") Integer itemId){
        return adminService.itemDetail(itemId);
    }

    @PutMapping("/itemdetail/updateitem/{itemId}")
    public Integer updateItem(@PathVariable("itemId") Integer itemId,
                              @RequestBody AdminUpdateItemRequest request){
        request.setItemId(itemId);
        return adminService.updateItem(request);
    }
}
