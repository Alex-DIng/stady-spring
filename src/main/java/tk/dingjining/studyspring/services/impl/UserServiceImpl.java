package tk.dingjining.studyspring.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import tk.dingjining.studyspring.dao.UserMapper;
import tk.dingjining.studyspring.entity.User;
import tk.dingjining.studyspring.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<User> getAllUsers() {
		// stringRedisTemplate.opsForValue().set("user1", "user2");
		// stringRedisTemplate.opsForHash().put("user2", "user2", "user2");
		BoundValueOperations<String, Object> userOpt = redisTemplate.boundValueOps("user2");
		List<User> users = (List<User>) userOpt.get();

		if (null == users) {
			synchronized (this) {
				users = (List<User>) userOpt.get();
				if (null == users) {
					System.out.println("-------------shujuku------------");
					users = userMapper.queryUserList();
					userOpt.set(users);
				} else {
					users = (List<User>) userOpt.get();
					System.out.println("-------------redis1------------");
				}
			}
		} else {
			System.out.println("-------------redis2------------");
		}
		return users;
	}

	@Override
	public List<User> getAllUsersById(String id) {
		return null;
	}
}