package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import com.hp.service.IUserService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserService implements IUserService{
	
	@Resource
	private UserMapper userMapper;

	@Override
	@Transactional(readOnly=true)
	public List<User> selectUsers() {
		
		
		return userMapper.selectList(new EntityWrapper<>());
	}

	@Override
	public void insertUser(User user) {
	
		userMapper.insert(user);
	}

	@Override
	@Transactional(readOnly=true)
	public User selectUserByUserId(Integer id) {
		
		return userMapper.selectById(id);
	}

	@Override
	public List<User> login(User user) {
		EntityWrapper<User> entityWrapper = new EntityWrapper<User>();
		entityWrapper.eq("username", user.getUsername());
		entityWrapper.eq("password", user.getPassword());
		List<User> list = userMapper.selectList(entityWrapper);
		return list;
	}

	@Override
	public void updateu(User user) {
		userMapper.updateById(user);
		
	}

	@Override
	public void deleteu(Integer id) {
		userMapper.deleteById(id);		
	}

}
