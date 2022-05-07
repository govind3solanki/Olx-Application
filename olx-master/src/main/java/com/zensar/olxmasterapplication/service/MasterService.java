package com.zensar.olxmasterapplication.service;

import java.util.List;

import com.zensar.olxmasterapplication.entity.CategoryDto;
import com.zensar.olxmasterapplication.entity.StatusDto;

public interface MasterService {

	List<CategoryDto> getAllCategory();

	List<StatusDto> getAllStatus();
}
