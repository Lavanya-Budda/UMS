package com.university.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserLogin")
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "login_date_and_time")
    private Date loginDateAndTime;
    @Column(name = "token")
    private String token;
    @Column(name="logout_date_and_time")
    private Date logoutDateAndTime;
    @Column(name = "u_id")
    private Long sId;

    public UserLogin(long id, Date loginDateAndTime, String token, Date logoutDateAndTime) {
        this.id = id;
        this.loginDateAndTime = loginDateAndTime;
        this.token = token;
        this.logoutDateAndTime = logoutDateAndTime;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public UserLogin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLoginDateAndTime() {
        return loginDateAndTime;
    }

    public void setLoginDateAndTime(Date loginDateAndTime) {
        this.loginDateAndTime = loginDateAndTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLogoutDateAndTime() {
        return logoutDateAndTime;
    }

    public void setLogoutDateAndTime(Date logoutDateAndTime) {
        this.logoutDateAndTime = logoutDateAndTime;
    }
}
