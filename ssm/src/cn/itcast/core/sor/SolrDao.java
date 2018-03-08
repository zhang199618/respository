package cn.itcast.core.sor;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface SolrDao {

	public List<User> search() throws Exception;
}
