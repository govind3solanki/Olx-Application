package com.zensar.couponservice.service;

import java.util.List;

import com.zensar.couponservice.entity.CouponDto;

public interface CouponService {

	List<CouponDto> getAllCoupon();

	CouponDto createCoupon(CouponDto coupon, String token);

	CouponDto updateStock(Integer couponId, CouponDto coupon);

	String deleteAllCoupon();

	String deleteCouponPara(Integer id);

	CouponDto findByCouponCode(String couponCode);

}

