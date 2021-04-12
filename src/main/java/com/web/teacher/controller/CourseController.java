package com.web.teacher.controller;

import com.web.teacher.pojo.Course;
import com.web.teacher.service.CourseService;
import com.web.teacher.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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


	@RequestMapping("queryAll")
	public String queryAll(String pageNo,ModelMap model) {
		List<Course> list = courseService.queryAll();

		PageBean<Course> pageBean = new PageBean<Course>();
		pageBean.page(list, pageNo);
		model.put("pageBean", pageBean);

		return "courselist";
	}


	@RequestMapping("delete")
	@ResponseBody
	public Integer delete(Integer cid) {
		courseService.delete(cid);
		return 1;
	}

	@RequestMapping("update")
	@ResponseBody
	public Course update(Course course) {
		courseService.update(course);
		Course a= courseService.getCourseByCid(course.getCid());
		return a;
	}

}
