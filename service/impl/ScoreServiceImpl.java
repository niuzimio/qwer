package com.web.teacher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.teacher.dao.ScoreDao;
import com.web.teacher.pojo.Course;
import com.web.teacher.pojo.Score;
import com.web.teacher.service.ScoreService;
@Service("scoreService")
public class ScoreServiceImpl  implements ScoreService{
	@Autowired
	private ScoreDao scoreDao;
	public List<Score> getByCid(int cid) {
		
		return scoreDao.getByCid(cid);
	}
	public List<Score> queryAll(){
		return scoreDao.queryAll();
	}
	public void add(Score score) {
		scoreDao.add(score);
	}
	public void delete(Integer snum) {
		scoreDao.delete(snum);
	}
	public void update(Score score) {
		scoreDao.update(score);
	}
	public Score getBySnum(int snum) {
		return scoreDao.getBySnum(snum);
	}
}
