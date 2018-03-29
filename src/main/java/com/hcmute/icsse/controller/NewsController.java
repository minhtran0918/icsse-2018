package com.hcmute.icsse.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hcmute.icsse.entity.Admin;
import com.hcmute.icsse.entity.News;
import com.hcmute.icsse.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService service;
	
	@GetMapping("/all-notifications")
	public String viewNotifications(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			List<News> newsList = (List<News>)service.findAllNews();
			request.setAttribute("newsList", newsList);
			return "admin/notifications";
		}
		return "redirect:/";
	}

	@GetMapping("/add-notification")
	public String addNotifications(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			return "admin/addnotification";
		}
		return "redirect:/";
	}

	@GetMapping("/edit-notification")
	public String editNotification(@RequestParam String id, HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm == null) {
			return "redirect:/";
		}
		try {
			int nid = Integer.parseInt(id);
			News news = service.findNews(nid);
			if(news == null) {
				return "redirect:/all-notifications";
			}
			request.setAttribute("news", news);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "admin/editnotification";
	}
	
	@PostMapping("/addnews")
	public String addNews(@RequestParam String ntitle, 
			@RequestParam String ncontent, 
			@RequestParam String nsubmit, 
			HttpServletRequest request) {
		if(nsubmit == null || nsubmit.equals("")) {
			return "redirect:/";
		}
		if(ncontent == null || ncontent.equals("") ||
				ntitle == null || ntitle.equals("")) {
			News errorNews = new News();
			errorNews.setNewsTitle(ntitle);
			errorNews.setNewsContent(ncontent);
			request.setAttribute("error", "Không được để trống.");
			request.setAttribute("news", errorNews);
			return "admin/addnotification";
		}
		Admin adm = LoginController.getAdmin(request);
		if(adm == null) {
			return "redirect:/";
		}
		News news = new News();
		news.setAdmin(adm);
		news.setNewsTime(new Date());
		news.setNewsContent(ncontent);
		news.setNewsTitle(ntitle);
		news = service.addNews(news);
		if(news != null) {
			return "redirect:/updrive?id="+news.getNewsId();
		}
		News errorNews = new News();
		errorNews.setNewsTitle(ntitle);
		errorNews.setNewsContent(ncontent);
		request.setAttribute("news", errorNews);
		request.setAttribute("error", "Thêm tin tức thất bại.");
		return "admin/addnotification";
	}
	
	@GetMapping("/deletenews")
	public String deleteNews(@RequestParam String id, HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm == null) {
			return "redirect:/";
		}
		try {
			int nid = Integer.parseInt(id);
			service.deleteNews(nid);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "redirect:/all-notifications";
	}
	
	@PostMapping("/editnews")
	public String editNews(@RequestParam String id, 
			@RequestParam String ntitle, 
			@RequestParam String ncontent, HttpServletRequest request) {	
			Admin adm = LoginController.getAdmin(request);
			if(adm == null) {
				return "redirect:/";
			}
			if(ncontent == null || ncontent.equals("") ||
					ntitle == null || ntitle.equals("")) {
				News errorNews = new News();
				errorNews.setNewsTitle(ntitle);
				errorNews.setNewsContent(ncontent);
				request.setAttribute("error", "Không được để trống.");
				request.setAttribute("news", errorNews);
				return "admin/editnotification";
			}
			try {
				int nid = Integer.parseInt(id);
				News news = service.findNews(nid);
				news.setNewsTitle(ntitle);
				news.setNewsContent(ncontent);
				if(service.updateNews(news) != null) {
					return "redirect:/updrive?id="+news.getNewsId();
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			News errorNews = new News();
			errorNews.setNewsTitle(ntitle);
			errorNews.setNewsContent(ncontent);
			request.setAttribute("news", errorNews);
			request.setAttribute("error", "Sửa tin tức thất bại.");
			return "admin/editnotification";
	}
	
	
	@GetMapping("/updrive")
	public String toUploadDrivePage(HttpServletRequest request) {
		if(LoginController.getAdmin(request) == null) {
			return "redirect:/";
		}
		return "admin/updrive";
	}
	
	@PostMapping("/updrive")
	public String uploadDrive(@RequestParam MultipartFile nfile ,
			@RequestParam String id, HttpServletRequest request) {
		if(LoginController.getAdmin(request) == null) {
			return "redirect:/";
		}
		if(nfile == null || id == null || id.equals("")) {
			return "redirect:/admin";
		}
		try {
			int nid = Integer.parseInt(id);
			News news = service.findNews(nid);
			if(news == null) {
				return "redirect:/updrive?id="+id;
			}
			if(!service.uploadImage(news, nfile)) {
				return "redirect:/updrive?id="+id;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "redirect:/all-notifications";
	}
}
