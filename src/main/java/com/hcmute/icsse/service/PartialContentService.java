package com.hcmute.icsse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmute.icsse.entity.PartialContent;
import com.hcmute.icsse.repository.PartialContentRepository;

@Service
public class PartialContentService {
	
	@Autowired
	private PartialContentRepository repostitory;
	
	public PartialContent updateContent(PartialContent content) {
		try {
			return repostitory.save(content);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public PartialContent findContentById(int id) {
		try {
			return repostitory.findById(id).get();
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}
	
}
