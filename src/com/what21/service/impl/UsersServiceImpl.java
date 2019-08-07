package com.what21.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.what21.dao.IUserDao;
import com.what21.model.Users;
import com.what21.service.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService {
	@Autowired
	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Users> getAll(Map<String,Object> map) {
		return userDao.findAll(map);
	}

	@Override
	public int countUsers() {
		return userDao.countUsers();
	}

	@Override
	public int addUsers(Users u) {
		return userDao.addUsers(u);
	}

	@Override
	public int updateUsers(Users u) {
		return userDao.updateUsers(u);
	}

	@Override
	public int deleteUsers(String id) {
		return userDao.deleteUsers(id);
	}
	
}
