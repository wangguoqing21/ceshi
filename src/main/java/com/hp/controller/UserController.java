package com.hp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hp.pojo.User;
import com.hp.service.IUserService;

@Controller
@RequestMapping
public class UserController {
	//11
	@Resource
	private IUserService userService;
	
	@RequestMapping("userInfo")
	public String hello(ModelMap map) {
		List<User> userlist = userService.selectUsers();
		map.put("userlist", userlist);
		
		return "user/userInfo";	
	}
	@RequestMapping(value="userEdit")
	public String userEdit(Integer id,ModelMap map) {
			if(id!=null) {
			
			//根据userId查询用户信息
			User user  = userService.selectUserByUserId(id);
			map.put("user", user);
			map.put("id", id);
		}else {
			map.put("user", new User());
		}
		
		return "user/userEdit";
	}
	@RequestMapping(value="addUser")
	public String insertUser(User user) {
	userService.insertUser(user);
	
	return "redirect:userInfo";	
	}
	@RequestMapping(value="addym")
	public String addym() {

	
	return "user/useradd";	
	}
	
	@RequestMapping(value="login")
	public String login(User user) {
		 List<User> list = userService.login(user);
		System.out.println(list.size());
		if(list.size()==1) {
			return "redirect:userInfo";	
		}else {
			return "user/login";
		}
	}
	@RequestMapping(value="loginym")
	public String loginym() {
		return "user/login";
		
	}
	@RequestMapping(value="updateu")
	public String updateu(User user) {
		userService.updateu(user);
		return "redirect:userInfo";
		
	}
	@RequestMapping(value="deleteu")
	public String deleteu(Integer id) {
		userService.deleteu(id);
		return "redirect:userInfo";
		
	}

}
