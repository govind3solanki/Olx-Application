package com.zensar.olxloginapplication.service;

import com.zensar.olxloginapplication.entity.TokenDto;
import com.zensar.olxloginapplication.entity.UserDto;

public interface LoginService {

	TokenDto userAuthentication(UserDto user);

	boolean logoutUser(String token1);

	UserDto ResisterUser(UserDto user);

	UserDto getUserInfo(long id, String token2);
}
