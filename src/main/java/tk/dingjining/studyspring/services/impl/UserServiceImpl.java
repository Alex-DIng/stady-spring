package tk.dingjining.studyspring.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tk.dingjining.studyspring.dao.UserMapper;
import tk.dingjining.studyspring.entity.User;
import tk.dingjining.studyspring.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> getAllUsers() {
		return userMapper.queryUserList();
	}
}