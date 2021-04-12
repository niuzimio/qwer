package com.web.teacher.dao;

import com.web.teacher.pojo.Admins;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public interface AdminDao {
    public Admins getAdminByAnum(Integer anum);
    public void updatepwd(Admins admins);
}

