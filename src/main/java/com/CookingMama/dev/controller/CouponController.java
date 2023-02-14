package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.dto.Coupons;
import com.CookingMama.dev.domain.request.AddCouponRequest;
import com.CookingMama.dev.domain.response.CouponListResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CouponController {
    private final CouponService couponService;
    private final SecurityService securityService;

    @GetMapping("/coupons")
    public List<CouponListResponse> getMyCoupons(){
        String token = securityService.getToken();
        List<CouponListResponse> myCoupon = couponService.selectMyCoupon(securityService.tokenToDTO(token).getId());
        if(myCoupon != null){
            return myCoupon;
        }
        return null;
    }
    @PostMapping("/coupons")
    public String addCoupon(@RequestBody AddCouponRequest couponCode){
        String checkCoupon = couponService.checkCoupon(couponCode.getCouponCode());
        if(checkCoupon == null){
            return "존재하지 않는 쿠폰 코드입니다.";
        }
        String token = securityService.getToken();
        AddCouponRequest request = new AddCouponRequest(securityService.tokenToDTO(token).getId(), checkCoupon);
        return couponService.addCoupon(request);
    }
    @PutMapping("/useCoupon")
    public Integer useCoupon(@RequestBody AddCouponRequest couponCode){
        String token = securityService.getToken();
        AddCouponRequest request = new AddCouponRequest(securityService.tokenToDTO(token).getId(), couponCode.getCouponCode());
        return couponService.useCoupon(request);
    }
}
