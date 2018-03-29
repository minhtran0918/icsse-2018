package com.hcmute.icsse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcmute.icsse.entity.Admin;
import com.hcmute.icsse.service.LoginService;

@Controller
public class LoginController {
	public static final String ADM = "admin";
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String toLogin(HttpServletRequest request) {
		Admin adm = getAdmin(request);
		if(adm == null) {
			return "admin/login";
		} else {
			return "redirect:/admin";
		}
	}
	
	@PostMapping("/login")
	public String admLogin(@RequestParam("uname") String uname, 
			@RequestParam("upass") String upass,
			@RequestParam("usubmit") String usubmit,
			HttpServletRequest request, RedirectAttributes r) {
		/*kiem tra xem nguoi dung co nhan nut submit 
		hoac dang o trang thai dang nhap hay khong*/
		if(usubmit == null || usubmit.equals("")) {
			return "redirect:/";
		}
		if(getAdmin(request) != null) {
			return "redirect:/admin";
		}
		if(uname == null || uname.equals("") ||
				upass == null || upass.equals("")) {
			request.setAttribute("error", "Không được để trống");
			return "admin/login";
		}
		//Kiem tra tai khoan
		Admin adm = loginService.checkAdminAccount(uname, upass);
		if(adm != null) {
			//Tao session luu tru thong tin tai khoan
			HttpSession session = request.getSession(true);
			session.setAttribute(ADM, adm);
			return "redirect:/admin";
		}
		request.setAttribute("error", "Kiểm tra tên đăng nhập, mật khẩu.");
		//Dang nhap that bai thi quay lai trang dang nhap
		return "admin/login";
	}
	
	public static Admin getAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return null;
		} else {
			return (Admin)session.getAttribute(ADM);
		}
	}
}
