package com.web.teacher.controller;
import com.web.teacher.pojo.Admins;
import com.web.teacher.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    @RequestMapping(value = "login", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Admins login(Admins admins, HttpSession session) {
        Admins a = adminService.getAdminByAnum(admins);
        if (a != null) {
            if (admins.getPwd() != null && a.getPwd().equals(admins.getPwd())) {
                session.setAttribute("loginUser", a);
                a.setPwd(null);
                return a;
            }
        }
        return null;
    }

    @RequestMapping("updatepwd")
    @ResponseBody
    public Integer updatepwd(Admins admins) {
        adminService.updatepwd(admins);
        return 1;
    }
}
