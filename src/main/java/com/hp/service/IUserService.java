package com.hp.service;

import java.util.List;

import com.hp.pojo.User;

public interface IUserService {
	public List<User> selectUsers();
	public void insertUser(User user);
	public User selectUserByUserId(Integer id);
	public List<User> login(User user);
	public void updateu(User user);
	public void deleteu(Integer id);

}
