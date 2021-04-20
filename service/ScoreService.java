package com.web.teacher.service;

import java.util.List;

import com.web.teacher.pojo.Course;
import com.web.teacher.pojo.Score;

public interface ScoreService {
	public List<Score> getByCid(int cid);
	public List<Score> queryAll();
	public void add(Score score);
	public void delete(Integer snum);
	public void update(Score Score);
	public Score getBySnum(int snum);
}
