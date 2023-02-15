package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.request.UserOrderCancelRequest;
import com.CookingMama.dev.domain.request.UserOrderRequest;
import com.CookingMama.dev.domain.response.OrderResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        Integer userId = securityService.tokenToDTO(token).getId();
        return orderService.addOrders(requests, userId);
    }
    @PutMapping("/orders/{orderNumber}")
    public String cancelOrders(
            @PathVariable("orderNumber") String orderNumber,
            @RequestBody List<UserOrderCancelRequest> requests){
        String token = securityService.getToken();
        Integer userId = securityService.tokenToDTO(token).getId();
        return orderService.cancelOrders(requests, userId, orderNumber);
    }

    @GetMapping("/orders")
    public List<OrderResponse> myOrders(){
        String token = securityService.getToken();
        return orderService.myOrders(securityService.tokenToDTO(token).getId());
    }
}
