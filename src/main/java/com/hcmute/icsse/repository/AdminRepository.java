package com.hcmute.icsse.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hcmute.icsse.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
	@Query(value="{call admLogin(?1, ?2)}",nativeQuery=true)
	public Admin admLogin(String uname, String upass);
}
