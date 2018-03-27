package com.yu.demo.domain;

/**
 * 客户管理系统的实体类
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-26 14:31
 */
public class CustomerDomain {

    private String id;
    private String name;        //姓名
    private String gender;      //性别
    //    private Date birthday;      //出生日期
    private String cellPhone;   //电话
    private String email;       //邮箱
    private String preference;   //爱好
    private String type;        //客户类型
    private String description; //客户描述

    /*无参构造*/
    public CustomerDomain() {

    }

    public CustomerDomain(String id, String name, String gender,
                          String cellPhone, String email, String preference,
                          String type, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.cellPhone = cellPhone;
        this.email = email;
        this.preference = preference;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CustomerDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", email='" + email + '\'' +
                ", preference='" + preference + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
