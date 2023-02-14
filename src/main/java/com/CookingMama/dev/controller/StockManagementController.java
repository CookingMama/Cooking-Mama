package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.response.StockManagementResponse;
import com.CookingMama.dev.service.StockManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class StockManagementController {
    private final StockManagementService stockManagementService;

    @GetMapping("/{adminId}")
    public List<StockManagementResponse> stockManagement(@PathVariable("adminId") Integer adminId){
        return stockManagementService.stockManagement(adminId);
    }
}
