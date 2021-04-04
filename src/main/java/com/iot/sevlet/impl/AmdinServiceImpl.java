package com.iot.sevlet.impl;

import com.iot.bean.Admin;
import com.iot.mapper.AdminMapper;
import com.iot.sevlet.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AmdinServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin GetAdminByAdminName(String adminName) {
        return adminMapper.GetAdminByAdminName(adminName);
    }

    @Override
    public void InsertAdmin(Admin admin) {
        adminMapper.InsertAdmin(admin);
    }
}
