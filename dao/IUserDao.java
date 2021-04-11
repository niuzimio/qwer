package com.web.teacher.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.User;

@Repository("userDao")
public interface IUserDao {
public User getUserByName(String uname);
public User getUserByUid(Integer uid);
/**
 * 添加用户
 */
public void add(User user);
/**
 * 根据主键删除用户
 */
public void delete(String uname);

/**
 * 根据主键查询用户
 */
public List<User> queryAll();
public List<User> searchUser2(User user);
public List<User> searchUser(User user);
public List<User> searchAttention(Operate operate);
public List<User> searchFans(User user);
/**
 * 用户修改
 */
public void updateflag(User user);
public void updateukey(User user);
public void update(User user);
public void updatepwd(User user);
public void updateunum(User user);
public void updatetnum(User user);
public void updatefnum(User user);
public void updatesnum(User user);
}

