package tk.dingjining.studyspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tk.dingjining.studyspring.entity.User;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String toLogin(HttpServletRequest request) {
		request.setAttribute("user", new User(1, "lisi", "123"));
		request.setAttribute("name", "zhangsan");
		return "login";
	}

}
