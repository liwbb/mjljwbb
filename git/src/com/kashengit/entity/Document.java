package com.kashengit.entity;

public class Document {
    private Integer id;
    private String name;
    private String savename;
    private String extname;
    private String md5;
    private Long size;
    private String displaysize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplaysize() {
        return displaysize;
    }

    public void setDisplaysize(String displaysize) {
        this.displaysize = displaysize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSavename() {
        return savename;
    }

    public void setSavename(String savename) {
        this.savename = savename;
    }

    public String getExtname() {
        return extname;
    }

    public void setExtname(String extname) {
        this.extname = extname;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", savename='" + savename + '\'' +
                ", extname='" + extname + '\'' +
                ", md5='" + md5 + '\'' +
                ", size='" + size + '\'' +
                ", displaysize='" + displaysize + '\'' +
                '}';
    }
}
