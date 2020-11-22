package tk.dingjining.studyspring.services;

import java.util.List;

import tk.dingjining.studyspring.entity.User;

public interface IUserService {
	List<User> getAllUsers();

	public List<User> getAllUsersById(String id);
}
