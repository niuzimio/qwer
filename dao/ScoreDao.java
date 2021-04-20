package com.web.teacher.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.teacher.pojo.Course;
import com.web.teacher.pojo.Score;

@Repository("scoreDao")
public interface ScoreDao {
	public List<Score> getByCid(int cid);
	public List<Score> queryAll();
	public void add(Score score);
	public Score getBySnum(int snum);
	public void delete(Integer snum);
	public void update(Score Score);
}
