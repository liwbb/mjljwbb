package com.kaishengit.entity;

public class Username {

    private Integer id;
    private String name;
    private String address;
    private float score;

    public Username() {
    }

    public Username(Integer id, String name, String address, float score) {
        this.id = id;
        this.score = score;
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Username{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
