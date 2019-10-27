package com.hp.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hp.pojo.User;

public interface UserMapper extends BaseMapper<User>{
	public List<User> selectUsers();
	public void insertUser(User user);
	public User login(User user);


}
