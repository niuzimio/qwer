package com.web.teacher.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.teacher.pojo.Announce;
import com.web.teacher.pojo.Suggestion;
import com.web.teacher.service.SuggestionService;

@Controller
public class SuggestionController {
	@Autowired
	@Qualifier("suggestionService")
	private SuggestionService suggestionService;
	
	@RequestMapping("suggestAdd")
	@ResponseBody
	public Integer add(Suggestion suggestion) {
	    int length =suggestion.getScontent().length();
	    if(length<=200)
	    {
			Date date = new Date();
			Date timestamp = new Date(date.getTime());
			suggestion.setStime(timestamp);
			suggestionService.add(suggestion);
			return 1;
		}
	    else
	    {
			   return -1;
	    }
	}
	
	@RequestMapping("queryAllSug")
	@ResponseBody
	public List<Suggestion> queryAll() {
		List<Suggestion> list = suggestionService.queryAll();
		return list;
	}
	@RequestMapping("getById")
	@ResponseBody
	public Suggestion getById(Integer id) {
		Suggestion s = suggestionService.getById(id);
		if (s != null){
		return s;
	    }
		else return null;
	}
}
