package com.CookingMama.dev.controller;


import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.ItemRegistRequest;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.ItemRegistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class ItemRegistController {
    private final ItemRegistService itemRegistService;
    private final SecurityService securityService;

    @PostMapping("/itemregist")
    public void insertItemRegist(@RequestBody ItemRegistRequest request){
        Integer adminId = securityService.tokenToAdminDTO(securityService.getToken()).getId();
        request.setAdminId(adminId);
        itemRegistService.insertItemRegist(request);
    }
}
