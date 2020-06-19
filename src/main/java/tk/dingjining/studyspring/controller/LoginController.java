package tk.dingjining.studyspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String toLogin(HttpServletRequest request) {
		request.setAttribute("name", "zhangsan");
		return "login";
	}

}
