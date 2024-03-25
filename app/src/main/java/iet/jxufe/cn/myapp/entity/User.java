package iet.jxufe.cn.myapp.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String account;
    private String password;
    private String name;
    private Integer userType;
    private Integer state;
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public User(Integer id, String account, String password, String name, Integer userType, Integer state, Integer isDeleted) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.state = state;
        this.isDeleted = isDeleted;
    }
}
