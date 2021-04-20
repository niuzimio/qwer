package com.web.teacher.service.impl;
import com.web.teacher.dao.AdminDao;
import com.web.teacher.pojo.Admins;
import com.web.teacher.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
        private AdminDao adminDao;
        public Admins getAdminByAnum(Admins admin) {
            Admins a =adminDao.getAdminByAnum(admin.getAnum());
            return a;
        }

        public void updatepwd(Admins admins) {
            adminDao.updatepwd(admins);
        }
}