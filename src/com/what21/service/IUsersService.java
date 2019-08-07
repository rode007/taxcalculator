package com.what21.service;

import java.util.List;
import java.util.Map;

import com.what21.model.Users;

public interface IUsersService {
	
	public List<Users> getAll(Map<String,Object> map);
	
	public int countUsers();
	public int addUsers(Users u);
	public int updateUsers(Users u);
	public int deleteUsers(String id);
}
