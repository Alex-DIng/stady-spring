package tk.dingjining.studyspring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.dingjining.studyspring.entity.User;
import tk.dingjining.studyspring.services.IUserService;

@Controller
//@PropertySource("classpath:db.properties")
@RequestMapping("/user")
public class UserController {
//
//	@Value("${user.username}")
//	private String username;
//
//	@Value("${user.hobby}")
//	private List<String> hobbies;
//
//	@GetMapping("/test")
//	@ResponseBody
//	public Map<String, Object> hello() {
//		Map<String, Object> map = new HashMap<>();
//		map.put(username, "ji");
//		System.out.println(username);
//		System.out.println(hobbies);
//		// int i = 1 / 0;
//		return map;
//	}
	@Resource
	private IUserService userService;

	@GetMapping
	@ResponseBody
	public List<User> getUsers() {
		List<User> list = userService.getAllUsers();
		return list;
	}

}
