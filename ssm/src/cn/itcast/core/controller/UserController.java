package cn.itcast.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		List<User> list = userService.findUserList();
		model.addAttribute("userList", list);
		return "list";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		return "insert";
	}
	
	@RequestMapping("/insert")
	public String list(User user, Model model) throws Exception {
		userService.add(user);
		return "forward:toAdd.action";
	}
}
