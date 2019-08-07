package com.what21.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.what21.model.Users;
import com.what21.service.IUsersService;
import com.what21.util.StringUtil;

@Controller
@RequestMapping(value = "/users")
public class UserAction {
	@Autowired
	private IUsersService usersService;
	
	@RequestMapping(value = "/findAll")
	public void findAll(HttpServletRequest request,HttpServletResponse response)throws Exception{
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startPage", (page-1)*rows);
		pageMap.put("endPage", rows);
		List<Users> u=usersService.getAll(pageMap);
		int total=usersService.countUsers();
		map.put("rows", u);
		map.put("total", total);
		String str=JSONObject.toJSONString(map);
		response.getWriter().write(str);
	}
	
	@RequestMapping(value="addUsers")
	public void addUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = StringUtil.getUUID();
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		Users u=new Users();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setAge(age);
		u.setEmail(email);
		int res=usersService.addUsers(u);
		System.out.println(res);
		Map<String, Object> map=new HashMap<String, Object>();
		if(res>0){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("errorMsg", "Save user fail !!!");
		}
		String str=JSONObject.toJSONString(map);
		response.getWriter().write(str);
		
	}
	@RequestMapping(value="updateUsers")
	public void updateUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		int id=Integer.parseInt(request.getParameter("id"));
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		Users u=new Users();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setAge(age);
		u.setEmail(email);
		int res=usersService.updateUsers(u);
		Map<String, Object> map=new HashMap<String, Object>();
		if(res>0){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("errorMsg", "update user fail !!!");
		}
		String str=JSONObject.toJSONString(map);
		response.getWriter().write(str);
	}
	@RequestMapping(value="deleteUsers")
	public void deleteUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id= request.getParameter("id");
		int res=usersService.deleteUsers(id);
		Map<String, Object> map=new HashMap<String, Object>();
		if(res>0){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("errorMsg", "update user fail !!!");
		}
		String str=JSONObject.toJSONString(map);
		response.getWriter().write(str);
	}
}
