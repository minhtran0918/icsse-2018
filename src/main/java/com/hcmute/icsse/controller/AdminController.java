package com.hcmute.icsse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcmute.icsse.entity.Admin;
import com.hcmute.icsse.service.AdminService;

@Controller
public class AdminController {

	public static String IMG_FOLDER = "admin/img/";

	@Autowired
	private AdminService admService;

	@GetMapping("/logout")
	public String admLogout(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			request.getSession(false).invalidate();
			return "redirect:/login";
		}
		return "redirect:/";
	}

	@GetMapping("/change-password")
	public String chnagePassword(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			return "admin/changepassword";
		} 
		return "redirect:/";
	}

	@GetMapping("/admin")
	public String adminHome(HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm != null) {
			return "admin/index";
		}
		return "redirect:/";
	}

	@PostMapping("/changepass")
	public String changePass(
			@RequestParam String oldPass,
			@RequestParam String newPass,
			@RequestParam String reNewPass,
			HttpServletRequest request) {
		Admin adm = LoginController.getAdmin(request);
		if(adm == null) {
			return "redirect:/";
		}
		if(oldPass == null || oldPass.equals("") || !oldPass.equals(adm.getAdmPass()) ||
				newPass == null || newPass.equals("") ||
				reNewPass == null || reNewPass.equals("") ||
				!newPass.equals(reNewPass)) {
			request.setAttribute("error", "Không được để trống, mật khẩu cũ phải đúng \nmật khẩu mới phải trùng nhau.");
			return "admin/changepassword";
		}
		adm.setAdmPass(newPass);
		if(admService.changePass(adm) == null) {
			adm.setAdmPass(oldPass);
			request.setAttribute("error", "Đổi mật khẩu thất bại.");
			return "admin/changepassword";
		} 
		return "redirect:/admin";
	}
}
