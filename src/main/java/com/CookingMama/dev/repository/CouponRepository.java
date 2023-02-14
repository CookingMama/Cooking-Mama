package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.Coupons;
import com.CookingMama.dev.domain.request.AddCouponRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponRepository {
    Integer addCoupon(AddCouponRequest request);
    Coupons checkCoupon(String couponCode);
    List<Coupons> selectMyCoupon(Integer id);
    Integer useCoupon(AddCouponRequest request);
}
