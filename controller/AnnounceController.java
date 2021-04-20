  
package com.web.teacher.controller;
import java.util.Date;
import com.web.teacher.pojo.Announce;
import com.web.teacher.pojo.Course;
import com.web.teacher.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AnnounceController {
	@Autowired
	@Qualifier("announceService")
	private AnnounceService announceService;
	@RequestMapping("announceAdd")
	@ResponseBody
	public Integer add(Announce announce) {
	    int length =announce.getAcontent().length();
	    if(length<=200)
	    {
			Date date = new Date();
			Date timestamp = new Date(date.getTime());
			announce.setAtime(timestamp);
			announceService.add(announce);
			return 1;
		}
	    else
	    {
			   return -1;
	    }
	}
	@RequestMapping("getByAid")
	@ResponseBody
	public Announce getByAid(Integer aid) {
		Announce a = announceService.getAnnounceByAid(aid);
		if (a != null){
		return a;
	    }
		else return null;
	}

	@RequestMapping("queryAllAnn")
	@ResponseBody
	public List<Announce> queryAll() {
		List<Announce> list = announceService.queryAll();
		return list;
	}


	@RequestMapping("deleteAnn")
	@ResponseBody
	public Integer delete(Integer aid) {
		announceService.delete(aid);
		return 1;
	}

	@RequestMapping("updateAnn")
	@ResponseBody
	public Announce update(Announce announce) {
		Date date = new Date();
		Date timestamp = new Date(date.getTime());
		announce.setAtime(timestamp);
		announceService.update(announce);
		Announce a= announceService.getAnnounceByAid(announce.getAid());
		return a;
	}

}