package com.web.teacher.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.User;
import com.web.teacher.service.IOperateService;
import com.web.teacher.service.IUserService;
import com.web.teacher.util.PageBean;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	@Autowired
	private IOperateService  opt;
	@RequestMapping(value = "login", produces = "application/json; charset=utf-8")
	@ResponseBody
	public User login(User user, HttpSession session) {
		System.out.println(user.getUname() + "==========login()============" + user.getPassword());
		User u = userService.login(user);
		if (u != null) {
			if (u.getPassword() != null && u.getPassword().equals(user.getPassword())) {
				session.setAttribute("loginUser", u);
				u.setPassword(null);
				return u;
			}
		}
		return null;
	}
	@RequestMapping(value = "login1", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Integer login1(User user, HttpSession session) {
		System.out.println(user.getUname() + "==========login()============" + user.getPassword());
		User u = userService.login(user);
		if (u != null) {
			/*
			 * if(u.getUkey()==2) { return 6; }
			 * 
			 * if(u.getUkey()==1) { return 5; }
			 */
			
			if (u.getPassword() != null && u.getPassword().equals(user.getPassword())) {
				session.setAttribute("loginUser", u);
				
				
				
				
				if (u.getFlag() == 1) {
					return 1;
				}
				if (u.getFlag() == 2) {
					return 2;
				} else {
					return 3;
				}
			}
			return 0;
		}
		return -1;
	}

	@RequestMapping("userAdd")
	@ResponseBody
	public Integer add(User user) {
		User u = userService.getUserByName(user.getUname());
	    int length =user.getUname().length();
	    if(length<=20)
	    {
		    if (u == null) 
		    {
		    user.setFlag(1);
		    user.setUnum(0);
		    user.setFnum(0);
		    user.setTnum(0);
		    user.setSnum(0);
		    user.setUkey(1);
			userService.add(user);
			return 1;
		} 
		    else 
		    {
			   return -1;
		    }
	    }
	    else return 0;
	}

	
	
	
	
	
	@RequestMapping("queryAll2")
	public String queryAll2(String pageNo, User user, ModelMap model) {
		List<User> list = userService.queryAll2(user);

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.page(list, pageNo);
		model.put("pageBean", pageBean);

//		model.put("list", list);
//		
		return "userlist2";
	}
	@RequestMapping("queryAll")
	public String queryAll(String pageNo, User user, ModelMap model) {
		List<User> list = userService.queryAll(user);

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.page(list, pageNo);
		model.put("pageBean", pageBean);

//		model.put("list", list);
//		
		return "userlist";
	}

	/**
	 * 锟斤拷询全锟斤拷 锟斤拷锟斤拷JSON http://192.168.18.245:8080/auth/queryAllJSON
	 */
	@RequestMapping("queryAllJSON")
	@ResponseBody
	public List<User> queryAllJSON(User user, ModelMap model) {

		return userService.queryAll(user);
	}

	/**
	 * 删锟斤拷
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Integer delete(String uname) {
		userService.delete(uname);
		return 1;
	}

	
	


	/**
	 * 淇敼鏁版嵁
	 */
	@RequestMapping("update")
	@ResponseBody
	public User update(User user) {
		userService.update(user);
		User u=userService.getUserByName(user.getUname());
		return u;
	}
	@RequestMapping("getpwd")
	@ResponseBody
	public  Integer getpwd(User user) {
		User user1=userService.getUserByName(user.getUname());
	    if(user.getPassword().equalsIgnoreCase(user1.getPassword()))
		{
			return 1;
		}
		else {
			return 0;
		}
	}
	@RequestMapping("updatepwd")
	@ResponseBody
	public Integer updatepwd(User user) {
		userService.updatepwd(user);
		return 1;
	}
	@RequestMapping("searchByName")
	@ResponseBody
	public User SearchName(String uname) {
		User user = userService.getUserByName(uname);
		return user;
	}
	@RequestMapping("searchuByuid")
	@ResponseBody
	public User searchuByuid(Integer uid) {
		User user = userService.getUserByUid(uid);
		return user;
	}
	@RequestMapping("searchAttention")
	@ResponseBody
	//我关注的人
	public List<User> searchAttention(Operate operate, ModelMap model) {
		
		return userService.searchAttention(operate);
	}
	@RequestMapping("searchFans")
	@ResponseBody
	//我的粉丝
	public List<User> searchFans(User user, ModelMap model) {
		
		return userService.searchFans(user);
	}
	@RequestMapping("searchUBytid")
	@ResponseBody
	public User Searchuid(Operate operate) {
		User user = userService.getUserByUid(opt.getGZuid(operate));
		return user;
	}
	@RequestMapping("updateflag")
	public String updateflag(Integer uid) {
		User user = userService.getUserByUid(uid);
		if (user.getFlag() == 1) {
			user.setFlag(2);
		} else {
			user.setFlag(1);
		}
		userService.updateflag(user);
		return "redirect:queryAll";
	}

	@RequestMapping("updateukey")
	public String updatekey(Integer uid) {
		User user = userService.getUserByUid(uid);
		if (user.getUkey() == user.STATUS_ABLE) {
			user.setUkey(0);
		} else {
			user.setUkey(1);
		}
		userService.updateukey(user);
		return "redirect:queryAll";
	}
	
	@RequestMapping("updateukey2")
	public String updatekey2(Integer uid) {
		User user = userService.getUserByUid(uid);
		if (user.getUkey() == user.STATUS_ABLE) {
			user.setUkey(0);
		} else {
			user.setUkey(1);
		}
		userService.updateukey(user);
		return "redirect:queryAll2";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("updatekey")
	@ResponseBody
	public int updateukey(String uname) {
		
		User user = userService.getUserByName(uname);
		if(user.getUkey()==0)
		{
			user.setUkey(2);
			userService.updateukey(user);
			return 1;
		}
		else if(user.getUkey()==1){
			return 0;
		}
		else
		{
			return 2;
		}
	}
}
