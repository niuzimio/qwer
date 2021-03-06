package com.web.teacher.service;

import com.web.teacher.pojo.Course;

import java.util.List;

public interface CourseService {
	public Course getCourseByName(String cname);
	public Course getCourseByCid(Integer cid);
	public void add(Course course);
	public void delete(Integer cid);

	public void update(Course course);

	public List<Course> queryAll();
}

