package com.web.teacher.dao;

import com.web.teacher.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teacherDao")
public interface TeacherDao {
public Teacher getTeacherByName(String tname);
public Teacher getTeacherById(Integer tid);

public void add(Teacher teacher);

public void delete(Integer tid);

public List<Teacher> queryAll();

public void update(Teacher teacher);
public void updatepwd(Teacher teacher);

}

