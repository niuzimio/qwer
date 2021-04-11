package com.web.teacher.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.pojo.Tiezidetail;
import com.web.teacher.pojo.User;
import com.web.teacher.service.IOperateService;
import com.web.teacher.service.ITieziService;
import com.web.teacher.service.IUserService;
@Controller
public class OperateController {
	@Autowired
	private IOperateService  opt;
	@Autowired
	private IUserService userService;
	@Autowired
	private ITieziService tieziService;

	@RequestMapping("XSGZ")
	@ResponseBody

	public Integer XSGZ(Operate operate)
	{
		Integer k1=opt.searchg(operate);
		return k1;
	}
	@RequestMapping("GZ")
	@ResponseBody
	public Integer GZ(Operate operate)
	{
		Integer k1=opt.searchg(operate);
		if(k1==0)
		{
			opt.addGZ(operate);
			 User user = userService.getUserByUid(operate.getUid());
			 user.setUnum(user.getUnum() + 1);
			 userService.updateunum(user);
			 User user1 = userService.getUserByUid(operate.getObj());
			 user1.setFnum(user1.getFnum() + 1);
			 userService.updatefnum(user1);
			 return 1;
		}
		if(k1==1)
		{
			User user = userService.getUserByUid(operate.getUid());
			 user.setUnum(user.getUnum() -1);
			 userService.updateunum(user);
			 User user1 = userService.getUserByUid(operate.getObj());
			 user1.setFnum(user1.getFnum()-1);
			 userService.updatefnum(user1);
			 opt.deleteGZ(operate);
			return 1;
		}
		return 1;
	}
	
	@RequestMapping("daGZ")
	@ResponseBody
	public Integer daGZ(Operate operate)
	{ //锟叫断癸拷注锟斤拷锟饺伙拷锟街达拷锟�
		Integer k1=opt.searctpo(operate);
		if(k1==0)
		{
			Integer key = opt.getGZuid(operate);
			operate.setObj(key);
			opt.addGZ(operate);
			 User user = userService.getUserByUid(operate.getUid());
			 user.setUnum(user.getUnum() + 1);
			 userService.updateunum(user);
			 User user1 = userService.getUserByUid(operate.getObj());
			 user1.setFnum(user1.getFnum() + 1);
			 userService.updatefnum(user1);
		}
		if(k1==1)
		{
			Integer key = opt.getGZuid(operate);
			operate.setObj(key); 
			 User user = userService.getUserByUid(operate.getUid());
			 user.setUnum(user.getUnum() -1);
			 userService.updateunum(user);
			 User user1 = userService.getUserByUid(operate.getObj());
			 user1.setFnum(user1.getFnum()-1);
			 userService.updatefnum(user1);
			 opt.deleteGZ(operate);
		}
		return 1;
	}
	/*
	@RequestMapping("AddSC")
	@ResponseBody
	public Integer addSC(Operate operate) {
		//锟秸诧拷
		 opt.addSC(operate);
		 return 1;
	}
	@RequestMapping("DeleteSC")
	@ResponseBody
	public Integer deleteSC(Operate operate)
	{//取锟斤拷锟秸诧拷
		opt.deleteSC(operate);
		return 1;
	}
	*/
	
	@RequestMapping("daSC")
	@ResponseBody
	
	public Integer daSC(Operate operate)
	{ //锟叫讹拷锟秸诧拷锟斤拷锟饺伙拷锟街达拷锟�
		Integer k2=opt.searcto(operate);
		if(k2==0)
		{
			opt.addSC(operate);
			User user=userService.getUserByUid(operate.getUid());
			user.setSnum(user.getSnum()+1);
			userService.updatesnum(user);
		}
		if(k2==1)
		{
			User user=userService.getUserByUid(operate.getUid());
			user.setSnum(user.getSnum()-1);
			userService.updatesnum(user);
			opt.deleteSC(operate);
		}
		return 1;
	}
	
	
//	@RequestMapping("AddDZ")
//	@ResponseBody
//	public Integer addDZ(Operate operate) {
//		//锟斤拷锟斤拷
//		 opt.addDZ(operate);
//		 return 1;
//	}
	@RequestMapping("DeleteDZ")
	@ResponseBody
	public Integer deleteDZ(Operate operate)
	{//取锟斤拷锟斤拷锟斤拷
		opt.deleteDZ(operate);
		return 1;
	}
	@RequestMapping("daDZ")
	@ResponseBody
	
	public Integer daDZ(Operate operate)
	{ //锟叫断碉拷锟斤拷锟斤拷锟饺伙拷锟街达拷锟�
		Integer k3=opt.searchtt(operate);
		if(k3==0)
		{
			opt.addDZ(operate);
			Tiezi tiezi=tieziService.getTieziByTid(operate.getObj());
			tiezi.setLnum(tiezi.getLnum()+1);
			tieziService.updatelnum(tiezi);
			 return 1;
		}
		if(k3==1)
		{
			Tiezi tiezi=tieziService.getTieziByTid(operate.getObj());
			tiezi.setLnum(tiezi.getLnum()-1);
			tieziService.updatelnum(tiezi);
			opt.deleteDZ(operate);
			return 1;
		}
		return 1;
	}
	@RequestMapping("searchtpo")
	@ResponseBody
	public Tiezidetail searchtpo(Operate operate)
	{   
		//锟斤拷锟斤拷锟斤拷锟斤拷页锟斤拷示
		Integer k1=opt.searctpo(operate);
		Integer k2=opt.searcto(operate);
		Integer k3=opt.searchtt(operate);
		Tiezi tiezi=tieziService.getTieziByTid(operate.getObj());
		Integer k4=tiezi.getLnum();
		Tiezidetail tiezidetail = new Tiezidetail();
		tiezidetail.setK1(k1);
		tiezidetail.setK2(k2);
		tiezidetail.setK3(k3);
		tiezidetail.setK4(k4);
		return tiezidetail;
	}
}
