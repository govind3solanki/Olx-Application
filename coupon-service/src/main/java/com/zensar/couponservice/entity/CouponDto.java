package com.zensar.couponservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDto {

	private Integer couponId;
	private String couponCode;
	private Double discount;
	private String expDate;
}
