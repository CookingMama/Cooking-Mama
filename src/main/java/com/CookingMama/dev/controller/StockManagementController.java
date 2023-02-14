package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.request.StockUpdateRequest;
import com.CookingMama.dev.domain.response.StockManagementResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.StockManagementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class StockManagementController {
    private final StockManagementService stockManagementService;
    private final SecurityService securityService;

    @GetMapping("/stockmanagement")
    public List<StockManagementResponse> stockManagement(){
        Integer adminId = securityService.tokenToAdminDTO(securityService.getToken()).getId();
        log.info(adminId.toString());
        return stockManagementService.stockManagement(adminId);
    }

    @PutMapping("/stockmanagement")
    public Integer stockUpdate(@RequestBody StockUpdateRequest request){
        Integer adminId = securityService.tokenToAdminDTO(securityService.getToken()).getId();
        request.setAdminId(adminId);
        log.info(request.toString());
        return stockManagementService.stockUpdate(request);
    }
}
