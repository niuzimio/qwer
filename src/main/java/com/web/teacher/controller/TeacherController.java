package com.web.teacher.controller;

import com.web.teacher.pojo.Teacher;
import com.web.teacher.service.TeacherService;
import com.web.teacher.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	@RequestMapping(value = "login", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Teacher login(Teacher teacher, HttpSession session) {
		Teacher t = teacherService.getTeacherById(teacher.getTid());
		if (t != null) {
			if (teacher.getTpwd() != null && teacher.getTpwd().equals(t.getTpwd())) {
				return t;
			}
		}
		return null;
	}

	@RequestMapping("teacherAdd")
	@ResponseBody
	public Integer add(Teacher teacher) {
		Teacher t = teacherService.getTeacherById(teacher.getTid());
		if (t == null)
		{
		teacherService.add(teacher);
		return 1;
	    }
		else return 0;
	}

	

	@RequestMapping("queryAll")
	public String queryAll(String pageNo, ModelMap model) {
		List<Teacher> list = teacherService.queryAll();

		PageBean<Teacher> pageBean = new PageBean<Teacher>();
		pageBean.page(list, pageNo);
		model.put("pageBean", pageBean);
		return "teacherlist";
	}

	@RequestMapping("delete")
	@ResponseBody
	public Integer delete(Integer tid) {
		teacherService.delete(tid);
		return 1;
	}


	@RequestMapping("update")
	@ResponseBody
	public Teacher update(Teacher teacher) {
		teacherService.update(teacher);
		Teacher t=teacherService.getTeacherById(teacher.getTid());
		return t;
	}

	@RequestMapping("updatepwd")
	@ResponseBody
	public Integer updatepwd(Teacher teacher) {
		teacherService.updatepwd(teacher);
		return 1;
	}
}
