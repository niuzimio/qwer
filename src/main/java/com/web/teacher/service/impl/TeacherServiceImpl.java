package com.web.teacher.service.impl;

import com.web.teacher.dao.TeacherDao;
import com.web.teacher.pojo.Teacher;
import com.web.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	   private TeacherDao teacherDao;
	   public Teacher getTeacherByName(String tname)
	   {
		    Teacher t=teacherDao.getTeacherByName(tname);
		    return t;
	   }
	   public Teacher getTeacherById(Integer tid)
	   {
		   Teacher t=teacherDao.getTeacherById(tid);
		   return t;
	   }
		public void add(Teacher teacher) {
			teacherDao.add(teacher);
		}
        public void delete(Integer tid)
        {
        	teacherDao.delete(tid);
        }

        public void update(Teacher teacher)
        {
        	teacherDao.update(teacher);
        }
        public void updatepwd(Teacher teacher)
        {
        	teacherDao.updatepwd(teacher);
        }

		
		public List<Teacher> queryAll() {
			
			return teacherDao.queryAll();
		}

		
}
