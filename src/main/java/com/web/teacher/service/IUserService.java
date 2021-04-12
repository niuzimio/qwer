package com.web.teacher.service;

import java.util.List;

import com.web.teacher.pojo.Announce;
import com.web.teacher.pojo.User;

public interface IUserService {
	public User login(User user);
	public User getUserByName(String uname);
	public User getUserByUid(Integer uid);
	public void add(User user);
	public void delete(String uname);
	public void updateflag(User user);
	public void updateukey(User user);
	public void updatepwd(User user);
	public void update(User user);
	public void updateunum(User user);
	public void updatetnum(User user);
	public void updatefnum(User user);
	public void updatesnum(User user);
	public List<Announce> queryAll();
	public List<User> queryAll(User user);
	public List<User> queryAll2(User user);
	public List<User> searchFans(User user);
}

