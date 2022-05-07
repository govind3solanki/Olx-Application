package com.zensar.olxadvertiesapplication.service;

import java.util.List;

import com.zensar.olxadvertiesapplication.entity.AdvertiseRequest;
import com.zensar.olxadvertiesapplication.entity.AdvertiseResponse;

public interface AdvertiseService {

	AdvertiseResponse addAdvertise(AdvertiseRequest advertise1, String token);

	AdvertiseResponse updateAdvertise(long id, AdvertiseRequest advertise2, String token2);

	List<AdvertiseResponse> getAllAdvertise(String token3);

	AdvertiseResponse getSpecificAdvertise(long id, String token4);

	boolean deleteSpecificAdvertise(long id, String token5);

	List<AdvertiseResponse> getFilteredAdvertise(String searchText, String category);

	List<AdvertiseResponse> getAdvertiseByText(String searchText);

	AdvertiseResponse getAdvertiseById(long postId, String token6);

}
