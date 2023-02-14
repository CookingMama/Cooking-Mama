package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.StockUpdateRequest;
import com.CookingMama.dev.domain.response.StockManagementResponse;
import com.CookingMama.dev.repository.StockManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockManagementService {
    private final StockManagementRepository stockManagementRepository;

    public List<StockManagementResponse> stockManagement(Integer adminId){
        List<Items> items = stockManagementRepository.stockManagement(adminId);
        List<StockManagementResponse> responses = items.stream()
                .map(StockManagementResponse::new)
                .collect(Collectors.toList());
        return responses;
    }
    
    public Integer stockUpdate(StockUpdateRequest request){
        return stockManagementRepository.stockUpdate(request);
    }
}
