package tk.dingjining.studyspring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import tk.dingjining.studyspring.entity.User;

@Mapper
public interface UserMapper {
	List<User> queryUserList();

	public List<User> queryUserListById(@Param("id") String id);
}