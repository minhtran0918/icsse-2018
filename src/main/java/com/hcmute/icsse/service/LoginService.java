package com.hcmute.icsse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmute.icsse.entity.Admin;
import com.hcmute.icsse.repository.AdminRepository;

@Service
public class LoginService {
	@Autowired
	private AdminRepository repository;
	
	public Admin checkAdminAccount(String uname, String upass) {
		try {
			return repository.admLogin(uname, upass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
