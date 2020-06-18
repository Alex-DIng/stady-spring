package tk.dingjining.studyspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@PropertySource("classpath:db.properties")
public class UserController {

	@Value("${user.username}")
	private String username;

	@Value("${user.hobby}")
	private List<String> hobbies;

	@GetMapping("/test")
	@ResponseBody
	public Map<String, Object> hello() {
		Map<String, Object> map = new HashMap<>();
		map.put(username, "ji");
		System.out.println(username);
		System.out.println(hobbies);
		// int i = 1 / 0;
		return map;
	}
}
