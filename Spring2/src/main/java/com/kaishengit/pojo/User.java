package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
    private static final long serialVersionUID = 7609015556257824357L;
    private Integer id;
    private String username;
    private Timestamp creatime;
    private Integer userid;
    private String userip;

    @Override
    public String toString() {
        return "userip{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", creatime=" + creatime +
                ", userid=" + userid +
                ", userip='" + userip + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }
}
