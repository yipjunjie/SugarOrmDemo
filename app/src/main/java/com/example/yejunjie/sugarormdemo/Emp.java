package com.example.yejunjie.sugarormdemo;

import java.io.Serializable;

/**
 * 人员基本信息
 * Created by chengjianjia on 16/4/7.
 */
public class Emp implements Serializable {

    private int emp_id; // 员工ID
    private String emp_name; // 员工姓名
    private int position_id; // 职位id
    private String position; // 职位
    private String avatar_url; // 头像地址
    private String oa_id; // 工号
    private String sex; // 性别，0：男；1：女
    private String staff; // 员工编制，1：内编；2：外编
    private String phone; // 手机号
    private int group_id; // 分组id
    private String group_name; // 分组名称

    private String account; // 账号
    private String email; // 邮箱
    private String state;// 员工状态，1：正常；2：冻结；3：删除

    private String password; //密码

    private transient boolean isChoose; // 是否被选择

    public Emp(int emp_id, String group_name){
        this.emp_id = emp_id;
        this.group_name = group_name;
    }

    public Emp(){}

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getPositon() {
        return position;
    }

    public void setPositon(String position) {
        this.position = position;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getOa_id() {
        return oa_id;
    }

    public void setOa_id(String oa_id) {
        this.oa_id = oa_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setIsChoose(boolean isChoose) {
        this.isChoose = isChoose;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
