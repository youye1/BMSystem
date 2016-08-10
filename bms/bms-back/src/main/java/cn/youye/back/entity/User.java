package cn.youye.back.entity;

import java.util.Date;

public class User{
    private String id;

    private String loginName;

    private String password;

    private String userName;

    private Long phone;

    private Date createDate;

    private Date updateDate;

    private String createBy;

    private String updateBy;

    private String imgurl;

    private String introduction;

    private String delFlag;

    public User(String id, String loginName, String password, String userName, Long phone, Date createDate, Date updateDate, String createBy, String updateBy, String imgurl, String introduction, String delFlag) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.imgurl = imgurl;
        this.introduction = introduction;
        this.delFlag = delFlag;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getImgurl() {
        return imgurl;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}