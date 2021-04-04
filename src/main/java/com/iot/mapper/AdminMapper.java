package com.iot.mapper;

import com.iot.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper  {

    public Admin GetAdminByAdminName(String adminName);
    public void InsertAdmin(Admin admin);
}
