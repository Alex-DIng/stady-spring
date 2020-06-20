package tk.dingjining.studyspring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tk.dingjining.studyspring.entity.User;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String toLogin(HttpServletRequest request) {
		request.setAttribute("user", new User(1, "lisi", "男"));
		request.setAttribute("name", "zhangsan");
		request.setAttribute("date", new Date());
		return "login";
	}

}
