package com.what21.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.what21.dao.IUserDao;
import com.what21.model.Users;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<Users> findAll(Map<String, Object> map) {
		 return sqlSessionTemplate.getMapper(IUserDao.class).findAll(map);
	}
	
	
	@Override
	public int countUsers() {
		return sqlSessionTemplate.getMapper(IUserDao.class).countUsers();
	}
	
	@Override
	public int addUsers(Users u){
		return sqlSessionTemplate.getMapper(IUserDao.class).addUsers(u);
	}
	
	@Override
	public int updateUsers(Users u) {
		return sqlSessionTemplate.getMapper(IUserDao.class).updateUsers(u);
	}
	
	@Override
	public int deleteUsers(String id) {
		return sqlSessionTemplate.getMapper(IUserDao.class).deleteUsers(id);
	}


}
