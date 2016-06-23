package com.kaishengit.entity;

import java.util.List;

public class Movie {
    private String jianjie      ;
    private String daoyan       ;
    private String sendtime     ;
    private String releaseyear  ;
    private String title        ;
    private String rate         ;
    private Integer id          ;

    @Override
    public String toString() {
        return "Movie{" +
                "jianjie='" + jianjie + '\'' +
                ", daoyan='" + daoyan + '\'' +
                ", sendtime='" + sendtime + '\'' +
                ", releaseyear='" + releaseyear + '\'' +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                ", id=" + id +
                '}';
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getDaoyan() {
        return daoyan;
    }

    public void setDaoyan(String daoyan) {
        this.daoyan = daoyan;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
