package icsse2018.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icsse2018.Service.NewsService;
import icsse2018.Service.UserService;
import icsse2018.model.News;
import icsse2018.model.User;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	@GetMapping("/login")
	public String Login(HttpServletRequest request) {
		HttpSession sesLg = request.getSession(false);
		if (sesLg.getAttribute("us") == null)
		{
			return "admin/login";
		}
		else
		{
			return "redirect:/";
		}
	}
	@PostMapping("/login")
	public String Login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		if(userService.findUser(username, password)!=null) {
			User u = userService.findUser(username, password);
			HttpSession sesLg = request.getSession(true);
			sesLg.setAttribute("us", u);
			
		return "redirect:/";
		}
		return "admin/login";
	}
	@GetMapping("/logout")
	public String Logout(HttpServletRequest request) {
		HttpSession sesLg = request.getSession(false);
		if (sesLg != null) {
		    sesLg.invalidate();
		}
		return "redirect:/";
	}
	@GetMapping("/manager")
	public String allTasks(HttpServletRequest request){
		HttpSession sesLg = request.getSession(false);
		if (sesLg.getAttribute("us") == null)
		{
			return "admin/login";
		}
		request.setAttribute("documents", newsService.findAll(1));
		request.setAttribute("mode", "MODE_TASKS");
		return "admin/manager";
	}
	
	@GetMapping("/new-news")
	public String newTask(HttpServletRequest request){
		HttpSession sesLg = request.getSession(false);
		if (sesLg.getAttribute("us") == null)
		{
			return "admin/login";
		}
		request.setAttribute("mode", "MODE_NEW");
		return "admin/manager";
	}
	@PostMapping("/save-news")
	public String saveTask(@ModelAttribute News news, BindingResult bindingResult, HttpServletRequest request){
		news.setDate(new Date());
		newsService.save(news);
		request.setAttribute("documents", newsService.findAll(1));
		request.setAttribute("mode", "MODE_TASKS");
		return "redirect:/manager";
	}
	
	@GetMapping("/update-news")
	public String updateTask(@RequestParam int id, HttpServletRequest request){
		HttpSession sesLg = request.getSession(false);
		if (sesLg.getAttribute("us") == null)
		{
			return "admin/login";
		}
		request.setAttribute("document", newsService.findNews(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "admin/manager";
	}
	
	@GetMapping("/delete-news")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		HttpSession sesLg = request.getSession(false);
		if (sesLg.getAttribute("us") == null)
		{
			return "admin/login";
		}
		newsService.delete(id);
		request.setAttribute("documents", newsService.findAll(1));
		request.setAttribute("mode", "MODE_TASKS");
		return "redirect:/manager";
	}
}
