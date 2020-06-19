package tk.dingjining.studyspring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tk.dingjining.studyspring.entity.User;

@Mapper
public interface UserMapper {
	List<User> queryUserList();
}