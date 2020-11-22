package tk.dingjining.studyspring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.dingjining.studyspring.entity.User;
import tk.dingjining.studyspring.util.R;

@Controller
public class LoginController {
	@GetMapping("/logins")
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

	@ResponseBody
	@PostMapping("login")
	public R doLogin(String username, String password, String vercode, HttpServletRequest request) {

		if ("".equals(username.trim()) || "".equals(password.trim())) {
			return R.build(500, "not null");
		}

		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			SecurityUtils.getSubject().login(token);
			return R.build(200, "成功");
		} catch (IncorrectCredentialsException ice) {
			return R.build(502, "密码错误");
		} catch (UnknownAccountException uae) {
			return R.build(503, "账号不存在");
		} catch (LockedAccountException e) {
			return R.build(504, "账号被锁定");
		} catch (ExcessiveAttemptsException eae) {
			return R.build(505, "操作频繁，请稍后再试");
		}
	}

	@GetMapping("/toLogin")
	public String toLogin() {
		return "login";

	}

	@GetMapping("/logout")
	public R logout() {
		SecurityUtils.getSubject().logout();
		return R.success();

	}
}
