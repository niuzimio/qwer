package com.web.teacher.dao;

import com.web.teacher.pojo.Admins;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public interface AdminDao {
    public Admins getAdminByAnum(int num);
    public void updatepwd(Admins admins);
}