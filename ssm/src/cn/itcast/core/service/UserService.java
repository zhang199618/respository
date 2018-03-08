package cn.itcast.core.service;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface UserService {

	public List<User> findUserList() throws Exception;
	
	public void add(User user) throws Exception;
}
