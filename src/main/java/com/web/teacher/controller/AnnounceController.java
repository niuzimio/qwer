package com.web.teacher.controller;
import java.security.Timestamp;
import java.util.Date;
import com.web.teacher.pojo.Announce;
import com.web.teacher.pojo.User;
import com.web.teacher.service.AnnounceService;
import com.web.teacher.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AnnounceController {
	@Autowired
	@Qualifier("announceService")
	private AnnounceService announceService;
	@Autowired

	@RequestMapping("announceAdd")
	@ResponseBody
	public Integer add(Announce announce) {
	    int length =announce.getAcontent().length();
	    if(length<=200)
	    {
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			announce.setAtime(timestamp);
			announce.setAcontent(announce.getAcontent());
			announce.setAnume(announce.getAnume());
			announceService.add(announce);
			return 1;
		}
	    else
	    {
			   return -1;
	    }
	}


	@RequestMapping("queryAll")
	public String queryAll(String pageNo, Announce announce, ModelMap model) {
		List<User> list = announceService.queryAll(announce);

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.page(list, pageNo);
		model.put("pageBean", pageBean);

		return "announcelist";
	}


	@RequestMapping("delete")
	@ResponseBody
	public Integer delete(Integer aid) {
		announceService.delete(aid);
		return 1;
	}

	@RequestMapping("update")
	@ResponseBody
	public Announce update(Announce announce) {
		announceService.update(announce);
		Announce a= announceService.getAnnounceByAid(announce.getAid());
		return a;
	}

}
