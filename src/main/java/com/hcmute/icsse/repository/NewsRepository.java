package com.hcmute.icsse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hcmute.icsse.entity.News;

public interface NewsRepository extends CrudRepository<News, Integer> {
	@Query(value="{call findLatestNews()}", nativeQuery=true)
	public List<News> findLatestNews();
}
