package tk.dingjining.studyspring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tk.dingjining.studyspring.entity.User;
import tk.dingjining.studyspring.services.IUserService;

@Controller
//@PropertySource("classpath:db.properties")
@RequestMapping("/user")
@Api("用户相关")
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
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@GetMapping
	@ResponseBody
	@ApiOperation("獲取用戶信息")
	@ApiImplicitParam(name = "id", value = "用户id", paramType = "int", defaultValue = "2")
	@ApiResponse(code = 200, message = "用户信息拿到了")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	@ApiImplicitParam(name = "id", value = "用户id", paramType = "path", defaultValue = "2")
	@ApiResponse(code = 200, message = "用户信息拿到了")
	@ResponseBody
	public User getUsers(@PathVariable int id) {
	

		return new User(id, "zhangsan", "11122");
	}

	@PutMapping
	@ResponseBody
	@ApiImplicitParam(name = "user", value = "用戶信息對象", paramType = "body", dataTypeClass = tk.dingjining.studyspring.entity.User.class)
	public String updateUsers(User user) {
		return "success";
	}

	@PostMapping("/add")
	@ResponseBody
	@ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "用戶名", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "密碼", dataType = "string", paramType = "query") })
	@ApiResponses({ @ApiResponse(code = 200, message = "成功了"), @ApiResponse(code = 400, message = "您的網頁丟失了") })
	public String addUsers(User user) {
		return "success";
	}

	@PostMapping
	@ResponseBody
	public String addUsers(String username, String password) {
		return "success";
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public String delUsers(@PathVariable int id) {
		return "success";
	}
}
