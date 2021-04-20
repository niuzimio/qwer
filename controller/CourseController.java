package com.web.teacher.controller;

import com.web.teacher.pojo.Course;
import com.web.teacher.pojo.Teacher;
import com.web.teacher.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class CourseController {
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@RequestMapping("courseAdd")
	@ResponseBody
	public Integer add(Course course) {
		Course c = courseService.getCourseByCid(course.getCid());
	    if(c==null)
	    {
			courseService.add(course);
			return 1;
		}
	    else
	    {
			   return -1;
	    }
	}


	@RequestMapping("queryAllC")
	@ResponseBody
	public List<Course> queryAll() {
		List<Course> list = courseService.queryAll();
		return list;
	}
	@RequestMapping("getByCid")
	@ResponseBody
	public Course getByCid(Integer cid) {
		Course c = courseService.getCourseByCid(cid);
		if (c != null){
		return c;
	    }
		else return null;
	}
	@RequestMapping("getByTid1")
	@ResponseBody
	public List<Course> getByTid(Integer tid) {
		List<Course> c = courseService.getCourseByTid(tid);
		if (c != null){
		return c;
	    }
		else return null;
	}
	@RequestMapping("deletec")
	@ResponseBody
	public Integer delete(Integer cid) {
		courseService.delete(cid);
		return 1;
	}

	@RequestMapping("updatec")
	@ResponseBody
	public Course update(Course course) {
		courseService.update(course);
		Course a= courseService.getCourseByCid(course.getCid());
		return a;
	}

}
