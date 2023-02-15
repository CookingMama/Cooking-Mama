package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.request.UserOrderCancelRequest;
import com.CookingMama.dev.domain.request.UserOrderRequest;
import com.CookingMama.dev.domain.response.OrderResponse;
import com.CookingMama.dev.repository.OrderRepository;
import com.CookingMama.dev.repository.StockManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final StockManagementRepository stockManagementRepository;

    public String addOrders(List<UserOrderRequest> requests, Integer userId){
        try{
            for (UserOrderRequest request : requests) {
                request.setUserId(userId);
                stockManagementRepository.userAddOrder(request.getItemCount(), request.getItemId());
            }
            Integer insertRows = orderRepository.addOrders(requests);
            if(insertRows != 0){
                return "주문이 성공적으로 완료되었습니다.";
            }
            return "주문에 실패하였습니다.";
        }catch (Exception e){
            return "재고가 부족합니다.";
        }
    }
    public String cancelOrders(List<UserOrderCancelRequest> requests, Integer userId, String orderNumber){
        Integer updateRows = orderRepository.cancelOrders(orderNumber, userId);
        for(UserOrderCancelRequest request : requests){
            stockManagementRepository.userCancelOrder(request);
        }

        if(updateRows != 0){
            return "주문이 취소되었습니다.";
        }
        return "주문 취소에 실패하였습니다.";
    }
    public List<OrderResponse> myOrders(Integer userId){
        return orderRepository.myOrders(userId);
    }
}
