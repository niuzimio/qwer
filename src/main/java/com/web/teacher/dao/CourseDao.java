package com.web.teacher.dao;

import com.web.teacher.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseDao")
public interface CourseDao {
public Course getCourseByName(String cname);
public Course getCourseByCid(Integer cid);

public void add(Course course);

public void delete(Integer cid);

public List<Course> queryAll();

public void update(Course course);

}

