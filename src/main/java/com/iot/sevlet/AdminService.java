package com.iot.sevlet;

import com.iot.bean.Admin;

public interface AdminService {
    public Admin GetAdminByAdminName(String adminName);
    public void InsertAdmin(Admin admin);
}
