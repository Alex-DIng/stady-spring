package tk.dingjining.studyspring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;
import org.omg.CORBA.NVList;
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
		List<User> users = new ArrayList<>();
		users.add(new User(1, "peter", "男"));
		users.add(new User(1, "mary", "女"));
		users.add(new User(1, "tom", "男"));
		request.setAttribute("users", users);
		Map<String, User> userMap = new HashMap<>();
		userMap.put("bz", new User(1, "peter", "男"));
		userMap.put("xw", new User(2, "mary", "女"));
		userMap.put("tw", new User(3, "tom", "男"));
		request.setAttribute("userMap", userMap);
		return "login";
	}

}
