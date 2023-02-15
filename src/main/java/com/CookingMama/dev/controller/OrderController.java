package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.request.UserOrderRequest;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class OrderController {
    private final OrderService orderService;
    private final SecurityService securityService;

    @PostMapping("/orders")
    public String addOrders(@RequestBody List<UserOrderRequest> requests){
        String token = securityService.getToken();
        Integer user_id = securityService.tokenToDTO(token).getId();
        return orderService.addOrders(requests, user_id);
    }
}
