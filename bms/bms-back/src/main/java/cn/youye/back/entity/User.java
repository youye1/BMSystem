package cn.youye.back.entity;

import java.util.Date;

public class User extends DataEntity<User> {
//    private String id;

    private String loginName;

    private String password;

    private String userName;

    private Long phone;

    private String imgurl;

    private String introduction;

    public User() {
        super();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}