package com.zensar.olxadvertiesapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseRequest {

	private long categoryId;
	private long statusId;
	private String title;
	private int price;
	private String description;
	}
