package com.zensar.olxmasterapplication.service;

import java.util.List;

import com.zensar.olxmasterapplication.entity.Category;
import com.zensar.olxmasterapplication.entity.Status;

public interface MasterService {

	List<Category> getAllCategory();

	List<Status> getAllStatus();
}
