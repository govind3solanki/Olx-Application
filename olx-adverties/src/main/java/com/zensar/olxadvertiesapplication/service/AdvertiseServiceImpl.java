package com.zensar.olxadvertiesapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertiesapplication.entity.Advertise;
import com.zensar.olxadvertiesapplication.entity.AdvertiseRequest;
import com.zensar.olxadvertiesapplication.entity.AdvertiseResponse;
import com.zensar.olxadvertiesapplication.repository.AdvertiseRepository;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	private AdvertiseRepository advertiseRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdvertiseResponse addAdvertise(AdvertiseRequest advertise1, String token) {
		if (token.equals("gs66548")) {
			Advertise advertise = new Advertise(0, null, 0, "Electronic goods", null, "anand", "xxx", "xxx", "OPEN");
			advertise.setId(advertise1.getCategoryId());
			advertise.setTitle(advertise1.getTitle());
			advertise.setPrice(advertise1.getPrice());
			advertise.setDescription(advertise1.getDescription());
			advertiseRepository.save(advertise);
			return modelMapper.map(advertise, AdvertiseResponse.class);
		} else
			return null;
	}

	@Override
	public AdvertiseResponse updateAdvertise(long id, AdvertiseRequest advertise2, String token2) {
		if (token2.equals("gs66548")) {
			AdvertiseResponse advertiseById = getAdvertiseById(id, token2);
			Advertise map = modelMapper.map(advertiseById, Advertise.class);
			map.setTitle(advertise2.getTitle());
			map.setPrice(advertise2.getPrice());
			// map.setId(advertise2.getStatusId());
			map.setDescription(advertise2.getDescription());
			return modelMapper.map(advertiseRepository.save(map), AdvertiseResponse.class);
		} else
			return null;
	}

	@Override
	public List<AdvertiseResponse> getAllAdvertise(String token3) {
		if (token3.equals("gs66548")) {
			List<Advertise> findAll = advertiseRepository.findAll();
			List<AdvertiseResponse> listOfResponse = new ArrayList<AdvertiseResponse>();
			for (Advertise advertise : findAll) {
				listOfResponse.add(modelMapper.map(advertise, AdvertiseResponse.class));
			}
			return listOfResponse;
		} else
			return null;
	}

	@Override
	public AdvertiseResponse getSpecificAdvertise(long id, String token4) {
		if (token4.equals("gs66548")) {
			Optional<Advertise> findById = advertiseRepository.findById(id);
			if (findById.isPresent())
				return modelMapper.map(findById.get(), AdvertiseResponse.class);
			else
				return null;
		} else
			return null;
	}

	@Override
	public boolean deleteSpecificAdvertise(long id, String token5) {
		if (token5.equals("gs66548")) {
			Optional<Advertise> findById = advertiseRepository.findById(id);
			if (findById.isPresent()) {
				Advertise advertise = findById.get();
				advertiseRepository.delete(advertise);
				;
				return true;
			} else
				return false;
		} else
			return false;
	}

	@Override
	public List<AdvertiseResponse> getFilteredAdvertise(String searchText, String category) {
		List<Advertise> findAll = advertiseRepository.searchByFilterCriteria(searchText, category);
		List<AdvertiseResponse> listOfResponse = new ArrayList<AdvertiseResponse>();
		for (Advertise advertise : findAll)
			listOfResponse.add(modelMapper.map(advertise, AdvertiseResponse.class));
		return listOfResponse;

	}

	@Override
	public List<AdvertiseResponse> getAdvertiseByText(String searchText) {

		List<Advertise> findAll = advertiseRepository.searchByText(searchText);
		List<AdvertiseResponse> listOfResponse = new ArrayList<AdvertiseResponse>();
		for (Advertise advertise : findAll)
			listOfResponse.add(modelMapper.map(advertise, AdvertiseResponse.class));
		return listOfResponse;

	}

	@Override
	public AdvertiseResponse getAdvertiseById(long postId, String token6) {
		if (token6.equals("gs66548")) {
			Optional<Advertise> findById = advertiseRepository.findById(postId);
			if (findById.isPresent())
				return modelMapper.map(findById.get(), AdvertiseResponse.class);
			else
				return null;
		} else
			return null;
	}

}
