package com.zensar.olxmasterapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxmasterapplication.entity.Category;
import com.zensar.olxmasterapplication.entity.Status;

@Service
public class MasterServiceImpl implements MasterService {

	static List<Category> categorys = new ArrayList<>();
	static {
		categorys.add(new Category(1, "Furniture"));
		categorys.add(new Category(2, "Cars"));
		categorys.add(new Category(3, "Mobiles"));
		categorys.add(new Category(4, "RealEstate"));
		categorys.add(new Category(5, "Sports"));
	}

	static List<Status> statusList = new ArrayList<>();
	static {
		statusList.add(new Status(1, "OPEN"));
		statusList.add(new Status(2, "CLOSE"));
	}

	@Override
	public List<Category> getAllCategory() {
		return categorys;
	}

	@Override
	public List<Status> getAllStatus() {
		return statusList;
	}

}
