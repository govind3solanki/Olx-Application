package com.zensar.olxmasterapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxmasterapplication.entity.Category;
import com.zensar.olxmasterapplication.entity.CategoryDto;
import com.zensar.olxmasterapplication.entity.Status;
import com.zensar.olxmasterapplication.entity.StatusDto;
import com.zensar.olxmasterapplication.repository.CategoryRepository;
import com.zensar.olxmasterapplication.repository.StatusRepository;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> findAll = categoryRepository.findAll();
		List<CategoryDto> list=new ArrayList<CategoryDto>();
		for(Category category:findAll) {
			CategoryDto dto = modelMapper.map(category,CategoryDto.class);
			list.add(dto);
		}
		return list;
	}

	@Override
	public List<StatusDto> getAllStatus() {
		List<Status> findAll = statusRepository.findAll();
		List<StatusDto> list=new ArrayList<StatusDto>();
		for(Status status:findAll) {
			StatusDto dto = modelMapper.map(status,StatusDto.class);
			list.add(dto);
		}
		return list;
		}

}
