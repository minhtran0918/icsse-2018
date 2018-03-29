package icsse2018.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icsse2018.Service.NewsService;

@Controller
public class MainController {
	@Autowired
	private NewsService newsService;

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("document", newsService.findNews(1));
		request.setAttribute("news", newsService.findAll(1));
		request.setAttribute("mode","MODE_PAGE");
		return "home";
	}
	@GetMapping("/page")
	public String Page(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("document", newsService.findNews(id));
		request.setAttribute("news", newsService.findAll(1));
		request.setAttribute("mode","MODE_PAGE");
		return "home";
	}
	@GetMapping("/all-news")
	public String allPage(HttpServletRequest request) {
		request.setAttribute("news", newsService.findAll(1));
		request.setAttribute("mode","MODE_NEWS");
		return "home";
	}
 
}
