package cn.hfjava.news.pojo;



import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    @Excel(name = "编号", orderNum = "0")
    private Integer userId;
    @Excel(name = "账号", orderNum = "1")
    private String userName;
    @Excel(name = "密码", orderNum = "2")
    private String password;
    @Excel(name = "邮箱", orderNum = "3")
    private String email;
    @Excel(name = "创建时间", exportFormat = "yyyy-MM-dd", orderNum = "4")
    private Date createDate;

    @ExcelIgnore()
    private Date modifyDate;

    @Excel(name = "是否删除", replace = {"未删除_0", "已删除_1"}, orderNum = "5")
    private Integer isDeleted;

    public User() {
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
