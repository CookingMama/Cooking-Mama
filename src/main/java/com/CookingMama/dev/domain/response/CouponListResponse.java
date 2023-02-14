package com.CookingMama.dev.domain.response;

import com.CookingMama.dev.domain.dto.Coupons;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponListResponse {
    private Integer couponId;
    private String couponName;
    private Integer couponPercentage;
    private Integer status;

    public CouponListResponse(Coupons coupons){
        this.couponId = coupons.getCouponId();
        this.couponName = coupons.getCouponName();
        this.couponPercentage = coupons.getCouponPercentage();
        this.status = coupons.getStatus();
    }
}
