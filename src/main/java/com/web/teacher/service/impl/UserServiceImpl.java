package com.web.teacher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.teacher.dao.IUserDao;
import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.User;
import com.web.teacher.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	   private IUserDao userDao;
	   public User getUserByName(String uname)
	   {
		    User dUser=userDao.getUserByName(uname);
		    return dUser;
	   }
	   public User getUserByUid(Integer uid)
	   {
		   User user=userDao.getUserByUid(uid);
		   return user;
	   }
	   public User  login(User user) {
			
			User dbuser = userDao.getUserByName(user.getUname());
			return dbuser;
		}
		
		
		public void add(User user) {
			user.setFlag(User.STATUS_ABLE);
			user.setUkey(User.STATUS_ABLE);
			userDao.add(user);
		}
        public void delete(String uname)
        {
        	userDao.delete(uname);
        }
        public void updateflag(User user)
        {
        	userDao.updateflag(user);
        }
        public void updateukey(User user)
        {
        	userDao.updateukey(user);
        }
        public void update(User user)
        {
        	userDao.update(user);
        }
        public void updatepwd(User user)
        {
        	userDao.updatepwd(user);
        }
        public void updateunum(User user)
        {
        	userDao.updateunum(user);
        }
        public void updatetnum(User user)
        {
        	userDao.updatetnum(user);
        }
        public void updatefnum(User user)
        {
        	userDao.updatefnum(user);
        }
        public void updatesnum(User user)
        {
        	userDao.updatesnum(user);
        }
		
		public List<User> queryAll() {
			
			return userDao.queryAll();
		}
		public List<User> queryAll(User user) {
			System.out.println(">>>>==="+user);
			if(user.getUkey()!=null && user.getUkey()==-1) {
				user.setUkey(null);
			}
			if(user.getFlag()!=null && user.getFlag()==-1) {
				user.setFlag(null);
			}
			if(user.getUname()==null || user.getUname().trim().equals("")) {
				user.setUname(null);
			}else{
				user.setUname("%"+user.getUname()+"%");
			}
			return userDao.searchUser(user);
		}
		
		
		
		
		
		
		public List<User> searchAttention(Operate operate) {
			
			return userDao.searchAttention(operate);
		}
		public List<User> searchFans(User user) {
			
			return userDao.searchFans(user);
		}
		public List<User> queryAll2(User user) {
			System.out.println(">>>>==="+user);
			if(user.getUkey()!=null && user.getUkey()==-1) {
				user.setUkey(null);
			}
			if(user.getFlag()!=null && user.getFlag()==-1) {
				user.setFlag(null);
			}
			if(user.getUname()==null || user.getUname().trim().equals("")) {
				user.setUname(null);
			}else{
				user.setUname("%"+user.getUname()+"%");
			}
			return userDao.searchUser2(user);
		}
		
}
