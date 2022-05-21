package com.zensar.couponservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.couponservice.entity.CouponDto;
import com.zensar.couponservice.service.CouponService;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping(value="/coupon/{couponCode}")
	public CouponDto findByCouponCode(@PathVariable String couponCode) {
		System.out.println("hello");
		return couponService.findByCouponCode(couponCode);
	}
	
	@GetMapping("/")
	public List<CouponDto> getAllCoupon() {
		return couponService.getAllCoupon();
	}

	@PostMapping(value = "/create")
	public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto coupon,
			@RequestHeader("auth-user") String token) {
		CouponDto createCoupon = couponService.createCoupon(coupon, token);
		if (createCoupon == null)
			return new ResponseEntity<CouponDto>(createCoupon, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<CouponDto>(createCoupon, HttpStatus.CREATED);
	}

	@PutMapping(value = "/put/{couponId}")
	public CouponDto updateStock(@PathVariable Integer couponId, @RequestBody CouponDto coupon) {
		return couponService.updateStock(couponId, coupon);
	}

	@DeleteMapping()
	public ResponseEntity<String> deleteAllCoupon() {
		String deleteAllCoupon = couponService.deleteAllCoupon();
		return new ResponseEntity<String>(deleteAllCoupon, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{couponId}")
	public String deleteCouponPara(@PathVariable("couponId") Integer id) {
		 System.out.println("create method..kjhkh....................");
		return couponService.deleteCouponPara(id);
	}

}
