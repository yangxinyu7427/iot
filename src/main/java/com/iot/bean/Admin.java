package com.iot.bean;

//import lombok.Data;
//
//@Data
public class Admin {
    private String adminName;
    private String adminPsd;
    private String email;

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPsd() {
        return adminPsd;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setAdminPsd(String adminPsd) {
        this.adminPsd = adminPsd;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
