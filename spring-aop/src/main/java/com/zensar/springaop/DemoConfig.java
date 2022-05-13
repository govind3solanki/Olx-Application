package com.zensar.springaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.zensar.springaop.dao.AccountDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.zensar.springaop.dao")
public class DemoConfig {
	 @Bean 
	   public AccountDAO accountDAO(){
	      return new AccountDAO();
	   }
	
}
