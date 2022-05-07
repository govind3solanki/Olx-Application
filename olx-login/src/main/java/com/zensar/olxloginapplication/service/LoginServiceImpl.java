package com.zensar.olxloginapplication.service;

import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxloginapplication.entity.Token;
import com.zensar.olxloginapplication.entity.TokenDto;
import com.zensar.olxloginapplication.entity.User;
import com.zensar.olxloginapplication.entity.UserDto;
import com.zensar.olxloginapplication.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	Token token = new Token();
		
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TokenDto userAuthentication(UserDto user) {
		if (user.getUserName().equals("anand") && user.getPassword().equals("anand123")) {
			token.setKye("auth-token");
			 Random rand = new Random();
		        int random = rand.nextInt(1000);
		        String s="gs6654"+random+"";
		        System.out.println(s);
			token.setValue(s);
			return modelMapper.map(token,TokenDto.class);
		}
		return null;
	}

	@Override
	public boolean logoutUser(String token1) {
		if (token1.equalsIgnoreCase(token.getValue())) {
			token.setKye(null);
			token.setValue(null);
			return true;
		} else
			return false;
	}

	@Override
	public UserDto ResisterUser(UserDto user) {
			loginRepository.save(modelMapper.map(user,User.class));
			return user;
	}

	@Override
	public UserDto getUserInfo(long id, String token2) {
		if (token.getValue().equals(token2)) {
			Optional<User> findById = loginRepository.findById(id);
			if (findById.isPresent()) {
				return modelMapper.map(findById.get(),UserDto.class);
			} else
				return null;
		} else
			return null;
	}

}
