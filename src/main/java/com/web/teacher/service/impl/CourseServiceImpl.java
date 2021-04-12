package com.web.teacher.service.impl;

import com.web.teacher.dao.CourseDao;

import com.web.teacher.pojo.Course;
import com.web.teacher.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService{
	@Autowired
	   private CourseDao courseDao;
	   public Course getCourseByName(String cname)
	   {
		    Course c=courseDao.getCourseByName(cname);
		    return c;
	   }
	   public Course getCourseByCid(Integer cid)
	   {
		   Course c=courseDao.getCourseByCid(cid);
		   return c;
	   }
		public void add(Course course) {
			course.setCid(course.getCid());
			course.setCname(course.getCname());
			course.setCyear(course.getCyear());
			course.setCteam(course.getCteam());
			course.setTid(course.getTid());
			course.setCredit(course.getCredit());
			course.setTime(course.getTime());
			course.setClassroom(course.getClassroom());
			courseDao.add(course);
		}
        public void delete(Integer cid)
        {
        	courseDao.delete(cid);
        }

        public void update(Course course)
        {
        	courseDao.update(course);
        }

		
		public List<Course> queryAll() {
			
			return courseDao.queryAll();
		}

}
