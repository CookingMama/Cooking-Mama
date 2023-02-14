package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.Coupons;
import com.CookingMama.dev.domain.request.AddCouponRequest;
import com.CookingMama.dev.domain.response.CouponListResponse;
import com.CookingMama.dev.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public String checkCoupon(String couponCode){
        String check = couponRepository.checkCoupon(couponCode).getCouponCode();
        if(check != null){
            return check;
        }
        return null;
    }
    public String addCoupon(AddCouponRequest request){
        try{
            Integer addRows = couponRepository.addCoupon(request);
            return "쿠폰 등록이 완료되었습니다.";
        }catch (Exception e) {
            return "이미 등록된 쿠폰입니다.";
        }
    }
    public List<CouponListResponse> selectMyCoupon(Integer id){
        try {
            List<Coupons> couponList = couponRepository.selectMyCoupon(id);
            List<CouponListResponse> responses = couponList.stream()
                    .map(CouponListResponse::new)
                    .collect(Collectors.toList());
            return responses;
        }catch(Exception e){
            return null;
        }
    }
    public Integer useCoupon(AddCouponRequest request){
        try{
            return couponRepository.useCoupon(request);
        }catch (Exception e){
            return null;
        }
    }
}
