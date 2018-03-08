package cn.itcast.core.sor;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.core.pojo.User;

@Repository
public class SolrDaoImpl implements SolrDao {
	
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public List<User> search() throws Exception {
		List<User> userList = new ArrayList<User>();
		//创建查询条件对象
		SolrQuery solrQuery = new SolrQuery();
		//设置查询所有
		solrQuery.setQuery("*:*");
		//查询并返回响应
		QueryResponse queryResponse = solrServer.query(solrQuery);
		//从响应中获取结果集
		SolrDocumentList results = queryResponse.getResults();
		//遍历结果集
		for(SolrDocument doc : results){
			User user = new User();
			user.setId(Integer.parseInt(String.valueOf(doc.get("id"))));
			user.setName(String.valueOf(doc.get("name")));
			user.setBirthday(String.valueOf(doc.get("birthday_dt")));
			userList.add(user);
		}
		return userList;
	}

}
