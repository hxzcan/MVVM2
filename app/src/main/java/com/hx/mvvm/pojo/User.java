package com.hx.mvvm.pojo;

/**
 * Created by hexiao on 2018/8/7.
 */

public class User {
    private String id;//

    private String username;//用户名

    private String account;//账号

    private String password;//密码

    private String sex;//性别

    private String deptid;//部门

    private String locked;

    private String remark;

    private String usertype;

    private String enabled;

    private String salt;//密码对用的盐

    private String active;//是否在线

    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", deptid='" + deptid + '\'' +
                ", locked='" + locked + '\'' +
                ", remark='" + remark + '\'' +
                ", usertype='" + usertype + '\'' +
                ", enabled='" + enabled + '\'' +
                ", salt='" + salt + '\'' +
                ", active='" + active + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
