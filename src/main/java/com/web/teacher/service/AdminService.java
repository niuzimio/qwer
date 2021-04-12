package com.web.teacher.service;

import com.web.teacher.pojo.Admins;

public interface AdminService {
    public Admins getAdminByAnum(Admins admins);
    public void updatepwd(Admins admins);
}
