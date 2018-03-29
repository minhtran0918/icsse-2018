package com.hcmute.icsse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcmute.icsse.ApplicationConfig;
import com.hcmute.icsse.entity.Admin;
import com.hcmute.icsse.entity.PartialContent;
import com.hcmute.icsse.service.PartialContentService;

@Controller
public class PartialContentController {
	
	@Autowired
	private PartialContentService service;
	
	@GetMapping("/edit-homepage")
	public String toEditHomePage(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			PartialContent pContent = service.findContentById(ApplicationConfig.INDEX_EDIT_FIRST_PAGE);
			request.setAttribute("pContent", pContent);
			request.setAttribute("page", "/edit-homepage");
			return "admin/editpage";
		}
		return "redirect:/"; 
	}

	@GetMapping("/edit-picturespage")
	public String toEditPicturesPage(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			PartialContent pContent = service.findContentById(ApplicationConfig.INDEX_EDIT_IMG_PAGE);
			request.setAttribute("pContent", pContent);
			request.setAttribute("page", "/edit-picturespage");
			return "admin/editpage";
		}
		return "redirect:/";
	}

	
	@PostMapping("/edit-homepage")
	public String editHomePage(@RequestParam("content") String content, 
			@RequestParam("submit") String submit, 
			HttpServletRequest request) {
		if(LoginController.getAdmin(request) == null) {
			return "redirect:/";
		}
		
		if(content == null || content.equals("") ||
				submit == null || submit.equals("")) {
			return "redirect:/edit-homepage";
		}

		PartialContent pContent = service.findContentById(ApplicationConfig.INDEX_EDIT_FIRST_PAGE);
		if(pContent == null) {
			return "redirect:/edit-homepage";
		}
		pContent.setContent(content);
		if(service.updateContent(pContent) == null) {
			return "redirect:/edit-homepage";
		}
		return "redirect:/admin";	
	}
	
	@PostMapping("/edit-picturespage")
	public String editPicturesPage(@RequestParam("content") String content, 
			@RequestParam("submit") String submit,
			HttpServletRequest request) {
		if(LoginController.getAdmin(request) == null) {
			return "redirect:/";
		}

		if(content == null || content.equals("") ||
				submit == null || submit.equals("")) {
			return "redirect:/edit-picturespace";
		}
		PartialContent pContent = service.findContentById(ApplicationConfig.INDEX_EDIT_IMG_PAGE);

		if(pContent == null) {
			return "redirect:/edit-picturespace";
		}
		pContent.setContent(content);
		if(service.updateContent(pContent) == null) {
			return "redirect:/edit-picturespace";
		}
		return "redirect:/admin";
	}
	
	@GetMapping("/edit-contactpage")
	public String toEditContactPage(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			PartialContent pContent = service.findContentById(ApplicationConfig.INDEX_EDIT_CONTACT_PAGE);
			request.setAttribute("pContent", pContent);
			request.setAttribute("page", "/edit-contactpage");
			return "admin/editpage";
		}
		return "redirect:/"; 
	}
	
	@PostMapping("/edit-contactpage")
	public String editContactPage(@RequestParam("content") String content, 
			@RequestParam("submit") String submit,
			HttpServletRequest request) {
		if(LoginController.getAdmin(request) == null) {
			return "redirect:/";
		}

		if(content == null || content.equals("") ||
				submit == null || submit.equals("")) {
			return "redirect:/edit-contactpage";
		}
		PartialContent pContent = service.findContentById(ApplicationConfig.INDEX_EDIT_CONTACT_PAGE);
		if(pContent == null) {
			return "redirect:/edit-contactpage";
		}
		pContent.setContent(content);
		if(service.updateContent(pContent) == null) {
			return "redirect:/edit-contactpage";
		}
		return "redirect:/admin";
	}
}
