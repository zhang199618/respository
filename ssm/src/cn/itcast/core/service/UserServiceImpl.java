package cn.itcast.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.dao.UserMapper;
import cn.itcast.core.pojo.User;
import cn.itcast.core.sor.SolrDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SolrDao solrDao;

	@Override
	public List<User> findUserList() throws Exception {
		List<User> list = solrDao.search();
		return list;
	}

	@Override
	public void add(User user) throws Exception{
		userMapper.add(user);
	}

}
