package com.CookingMama.dev.controller;


import com.CookingMama.dev.domain.request.ItemRegistRequest;
import com.CookingMama.dev.service.ItemRegistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class ItemRegistController {
    private final ItemRegistService itemRegistService;

    @PostMapping("/itemregist")
    public void insertItemRegist(@RequestBody ItemRegistRequest request){
        itemRegistService.insertItemRegist(request);
    }
}
