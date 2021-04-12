package com.web.teacher.service;

import com.web.teacher.pojo.Teacher;

import java.util.List;

public interface TeacherService {
	public Teacher getTeacherByName(String tname);
	public Teacher getTeacherById(Integer tid);
	public void add(Teacher teacher);
	public void delete(Integer tid);

	public void updatepwd(Teacher teacher);
	public void update(Teacher teacher);

	public List<Teacher> queryAll();
}

