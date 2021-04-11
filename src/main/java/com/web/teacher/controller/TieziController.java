package com.web.teacher.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.pojo.User;
import com.web.teacher.service.ITieziService;
import com.web.teacher.service.IUserService;
import com.web.teacher.util.PageBean;
@Controller
public class TieziController {
	
	   @Autowired
       private ITieziService tieziService;
	   @Autowired
	   private IUserService userService;
		
	   
	   //鍙戣〃甯栧瓙
	   @RequestMapping("addtiezi")
       @ResponseBody
       public Integer addtiezi(Tiezi tiezi)
       {
		   int t = tiezi.getContent().length();
		   int s = tiezi.getTitle().length();
		   if(t<=200&&s<=30)
		   {
			   tiezi.setJsign(0);
			   tiezi.setLnum(0);
			   tieziService.add(tiezi);
			   User user = userService.getUserByName(tiezi.getUname());
			   user.setTnum(user.getTnum() + 1);
			   userService.updatetnum(user);
    	       return 1;  
		   }
		   else 
		   {
			   return 0;
		   }
       }
	   
       //鏌ヨ鍏ㄩ儴甯栧瓙
	   @RequestMapping("searchAll1")
		public String searchAll(String pageNo, Tiezi tiezi, ModelMap model) {

			List<Tiezi> list = tieziService.searchAll(tiezi);
			PageBean<Tiezi> pageBean = new PageBean<Tiezi>();
			pageBean.page(list, pageNo);
			model.put("pageBean", pageBean);
	
			return "tiezi";
		}

	   
		   @RequestMapping("searchAll")
	       @ResponseBody
	   	   public List<Tiezi> search(Tiezi tiezi,ModelMap model)
	       {
	    	   //显示全部帖子
	    	   return tieziService.searchAll(tiezi);
	   	   }
       //鏍规嵁鏍囬妯＄硦鏌ヨ
       @RequestMapping("search")
       @ResponseBody
   	   public List<Tiezi> search1(Tiezi tiezi,ModelMap model) 
       {
    	   return tieziService.searchAll(tiezi);
   	   }
       
       //鏍规嵁鏉垮潡鏌ヨ
       @RequestMapping("searchBysection")
       @ResponseBody
   	   public List<Tiezi> searchBysection (String section ,ModelMap model)
       {
    	   return tieziService.searchBysection(section);
   	   }
       
       //删除已发表帖子
       @RequestMapping("delete1")
       @ResponseBody
       public Integer delete1(Integer obj)
       {
    	   Tiezi tiezi = tieziService.getTieziByTid(obj);
    	   User user= userService.getUserByName(tiezi.getUname());
		   user.setTnum(user.getTnum()-1);
		   userService.updatetnum(user);
		   tieziService.delete(obj);
   		   return 1;         
       }
       @RequestMapping("delete2")
       public String delete2(Integer obj)
       {
    	   Tiezi tiezi = tieziService.getTieziByTid(obj);
    	   User user= userService.getUserByName(tiezi.getUname());
		   user.setTnum(user.getTnum()-1);
		   userService.updatetnum(user);
		   tieziService.delete(obj);
   		   return "redirect:searchAll1";         
       }
       @RequestMapping("updatejsign")
   	    public String updatejsign(Integer tid) {
   		Tiezi tiezi=tieziService.getTieziByTid(tid);
   		if(tiezi.getJsign()==0)
   		{
   			tiezi.setJsign(1);
   		}
   		else {
			tiezi.setJsign(0);
		}
   		tieziService.updatejsign(tiezi);
   		return "redirect:searchAll1";
   	}
       @RequestMapping("Recommend")
       @ResponseBody
       public List<Tiezi> Recommend(Tiezi tiezi,ModelMap model) 
       {
    	   return tieziService.searchRe(tiezi);
   	   }
       
       @RequestMapping("Jinghua")
       @ResponseBody
       public List<Tiezi> Jinghua(Tiezi tiezi,ModelMap model) 
       {
    	   return tieziService.searchJinghua(tiezi);
   	   }
       
      @RequestMapping("queryAllByS")
   	  @ResponseBody
   	  //收藏的帖子
   	  public List<Tiezi> searchtiezi(Operate operate, ModelMap model)
    	{
   		   return tieziService.searchByS(operate);
    	}
      
      
      @RequestMapping("queryAllByRe")
   	  @ResponseBody
   	  //关注的人帖子
   	  public List<Tiezi> searchByRe(Operate operate, ModelMap model)
    	{
   		   return tieziService.searchByRe(operate);
    	}
      
      @RequestMapping("queryMytiezi")
   	  @ResponseBody
   	  //我帖子
   	  public List<Tiezi> searchMytiezi(Tiezi tiezi, ModelMap model)
    	{
   		   return tieziService.searchMyTiezi(tiezi);
    	}
      @RequestMapping("searchBytid")
   	  @ResponseBody
   	  public Tiezi searchBytid(Integer tid, ModelMap model)
    	{
   		   return tieziService.getTieziByTid(tid);
    	}  
      @RequestMapping("searchtid")
   	  @ResponseBody
      public List<Tiezi> searchtieziTid(Tiezi tiezi, ModelMap model)
  	{
 		   return tieziService.getTieziTid(tiezi);
  	}
      @RequestMapping("searchtbyuid")
   	  @ResponseBody
      public List<Tiezi> searchtbyuid(Integer uid, ModelMap model)
  	{
 		   return tieziService.searchtbyuid(uid);
  	}
      @RequestMapping("toUpdate")
    	public String toUpdate(Integer tid,ModelMap model) {
    		Tiezi tiezi=tieziService.getTieziByTid(tid);
    		model.put("tiezi", tiezi);
    		return "tiezidetails";
    	}

}
