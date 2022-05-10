package com.zensar.olxadvertiesapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertiesapplication.entity.AdvertiseRequest;
import com.zensar.olxadvertiesapplication.entity.AdvertiseResponse;
import com.zensar.olxadvertiesapplication.service.AdvertiseService;

@RestController
public class AdvertiesController {

	@Autowired
	private AdvertiseService advertiseService;

	// request 7
	@PostMapping(value = "/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseResponse addAdvertise(@RequestBody AdvertiseRequest advertise1,
			@RequestHeader("auth-token") String token) {
		return advertiseService.addAdvertise(advertise1, token);
	}

	// request 8
	@PutMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseResponse updateAdvertise(@PathVariable long id, @RequestBody AdvertiseRequest advertise2,
			@RequestHeader("auth-token") String token2) {
		return advertiseService.updateAdvertise(id, advertise2, token2);
	}

	// request 9
	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseResponse> getAllAdvertise(@RequestHeader("auth-token") String token3) {
		return advertiseService.getAllAdvertise(token3);
	}

	// request 10
	@GetMapping(value = "/user/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseResponse getSpecificAdvertise(@PathVariable long id, @RequestHeader("auth-token") String token4) {
		return advertiseService.getSpecificAdvertise(id, token4);
	}

	// request 11
	@DeleteMapping("/user/advertise/{id}")
	public boolean deleteSpecificAdvertise(@PathVariable long id, @RequestHeader("auth-token") String token5) {
		return advertiseService.deleteSpecificAdvertise(id, token5);
	}

	// request 12
	@GetMapping(value = "/advertise/search/filtercriteria", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseResponse> getFilteredAdvertise(
			@RequestParam(value = "searchText", defaultValue = "OPEN", required = false) String searchText,
			@RequestParam(value = "category", defaultValue = "Computer Goods", required = false) String category) {
		return advertiseService.getFilteredAdvertise(searchText, category);
	}

	// request 13
	@GetMapping(value = "/advertise/search", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseResponse> getAdvertiseByText(
			@RequestParam(value = "searchText", required = true) String searchText) {
		return advertiseService.getAdvertiseByText(searchText);
	}

	// request 14
	@GetMapping(value = "/advertise/{postId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseResponse getAdvertiseById(@PathVariable long postId, @RequestHeader("auth-token") String token6) {
		return advertiseService.getAdvertiseById(postId, token6);
	}

}
