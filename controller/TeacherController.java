package com.web.teacher.controller;

import com.web.teacher.pojo.Teacher;
import com.web.teacher.service.TeacherService;
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
	@RequestMapping(value = "login1", produces = "application/json; charset=utf-8")
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
	@RequestMapping("getByTid")
	@ResponseBody
	public Teacher getBytid(Integer tid) {
		Teacher t = teacherService.getTeacherById(tid);
		if (t != null){
		return t;
	    }
		else return null;
	}
	

	@RequestMapping("queryAllT")
	@ResponseBody
	public List<Teacher> queryAll(String pageNo, ModelMap model) {
		List<Teacher> list = teacherService.queryAll();

		return list;
	}

	@RequestMapping("deletet")
	@ResponseBody
	public Integer delete(Integer tid) {
		teacherService.delete(tid);
		return 1;
	}


	@RequestMapping("updatet")
	@ResponseBody
	public Teacher update(Teacher teacher, HttpSession session) {
		teacherService.update(teacher);
		Teacher t=teacherService.getTeacherById(teacher.getTid());
		return t;
	}

	@RequestMapping("updatepwdt")
	@ResponseBody
	public Integer updatepwd(Teacher teacher) {
		teacherService.updatepwd(teacher);
		return 1;
	}
}