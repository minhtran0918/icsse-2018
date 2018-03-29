package com.hcmute.icsse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcmute.icsse.ApplicationConfig;
import com.hcmute.icsse.entity.News;
import com.hcmute.icsse.entity.PartialContent;
import com.hcmute.icsse.service.AdminService;
import com.hcmute.icsse.service.NewsService;
import com.hcmute.icsse.service.PartialContentService;

@Controller
public class HomeController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private PartialContentService partialContentService;
	
	@GetMapping("/")
	public String toIndex(HttpServletRequest request) {
		findLatestNews(request);
		PartialContent content = partialContentService.findContentById(ApplicationConfig.INDEX_EDIT_FIRST_PAGE);
		request.setAttribute("pContent", content);
		return "index";
	}
	
	@GetMapping("/venue_hotel")
	public String pictures(HttpServletRequest request) {
		findLatestNews(request);
		PartialContent content = partialContentService.findContentById(ApplicationConfig.INDEX_EDIT_IMG_PAGE);
		request.setAttribute("pContent", content);
		return "pictures";
	}
	
	@GetMapping("/contacts")
	public String contact(HttpServletRequest request) {
		findLatestNews(request);
		PartialContent content = partialContentService.findContentById(ApplicationConfig.INDEX_EDIT_CONTACT_PAGE);
		request.setAttribute("pContent", content);
		return "contacts";
	}
	
	@GetMapping("/notification")
	public String viewDetailNotification(
			@RequestParam String id,
			HttpServletRequest request) {
		try {
			int nid = Integer.parseInt(id);
			News news = newsService.findNews(nid);
			if(news == null) {
				return "redirect:/";
			} else {
				request.setAttribute("news", news);
			}
			findLatestNews(request);
		} catch (NumberFormatException e) {
			return "redirect:/";
		}
		return "notification";
	}
	
	@GetMapping("/list-notifications")
	public String viewAllNotification(HttpServletRequest request) {
		findLatestNews(request);
		return "listnotifications";
	}
	
	private void findLatestNews(HttpServletRequest request) {
		List<News> newsList = newsService.findLatestNews();
		request.setAttribute("newsList", newsList);
	}
}
