package com.what21.dao;

import java.util.List;
import java.util.Map;

import com.what21.model.Users;

public interface IUserDao {
	public int countUsers();
	public List<Users> findAll(Map<String, Object> map);
	public int addUsers(Users u);
	public int updateUsers(Users u);
	public int deleteUsers(String id);
	
}
