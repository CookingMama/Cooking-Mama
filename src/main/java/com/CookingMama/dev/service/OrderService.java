package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.request.UserOrderRequest;
import com.CookingMama.dev.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public String addOrders(List<UserOrderRequest> requests, Integer user_id){
        for (UserOrderRequest request : requests) {
            request.setUserId(user_id);
        }
        Integer insertRows = orderRepository.addOrders(requests);
        if(insertRows != 0){
            return "주문이 성공적으로 완료되었습니다.";
        }
        return "주문에 실패하였습니다.";
    }
}
