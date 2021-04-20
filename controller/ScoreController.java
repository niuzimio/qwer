package com.web.teacher.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.teacher.pojo.Score;
import com.web.teacher.pojo.Teacher;
import com.web.teacher.service.ScoreService;

@Controller
public class ScoreController {
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	@RequestMapping("getBySid")
	@ResponseBody
	public List<Score> getByCid(int cid, ModelMap model) {

		return scoreService.getByCid(cid);
	}@RequestMapping("getBySnum")
	@ResponseBody
	public Score getBySnum(int snum, ModelMap model) {

		return scoreService.getBySnum(snum);
	}
	@RequestMapping("ScoreAll")
	@ResponseBody
	public List<Score> queryAll() {

		return scoreService.queryAll();
	}
	@RequestMapping("scoreAdd")
	@ResponseBody
	public Integer add(Score score) {
		Score s = scoreService.getBySnum(score.getSnum());
		if (s == null)
		{
		scoreService.add(score);;
		return 1;
	    }
		else return 0;
	}
	@RequestMapping("deletesco")
	@ResponseBody
	public Integer delete(Integer snum) {
		scoreService.delete(snum);
		return 1;
	}
	@RequestMapping("updatesco")
	@ResponseBody
	public Score update(Score score, HttpSession session) {
		scoreService.update(score);
		Score s=scoreService.getBySnum(score.getSnum());
		return s;
	}
}
