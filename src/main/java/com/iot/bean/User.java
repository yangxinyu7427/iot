package com.iot.bean;


//import lombok.Data;
//
//@Data
public class User {

    private String Username;
    private String UserPsd;
    private String email;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUserPsd() {
        return UserPsd;
    }

    public void setUserPsd(String userPsd) {
        UserPsd = userPsd;
    }
    public String toString(){
        return "[Username=" + Username
                + ",UserPsd=" + UserPsd
                + ",email=" + email + "]";
    }

}
