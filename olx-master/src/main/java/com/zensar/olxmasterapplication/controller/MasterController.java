package com.zensar.olxmasterapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterapplication.entity.CategoryDto;
import com.zensar.olxmasterapplication.entity.StatusDto;
import com.zensar.olxmasterapplication.service.MasterService;

@RestController
@RequestMapping("/advertise")
public class MasterController {

	@Autowired
	private MasterService masterService;

	// request 5
	@GetMapping(value = "/category", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CategoryDto> getAllCategory() {
		List<CategoryDto> allCategory = masterService.getAllCategory();
		return allCategory;
	}

	// request 6
	@GetMapping(value = "/status", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<StatusDto> getAllStatus() {
		List<StatusDto> allStatus = masterService.getAllStatus();
		return allStatus;
	}
}
