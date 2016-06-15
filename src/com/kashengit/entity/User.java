package com.kashengit.entity;

public class User {
    private Integer id;
    private Integer code;
    private Object name;
    private Object tel;
public User(){};
    public User( Integer code,Object name, Object tel) {
        this.tel = tel;
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getTel() {
        return tel;
    }

    public void setTel(Object tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return id +
                "\t" + code +
                "\t" + name +
                "\t" + tel +
                "\t";
    }
}
