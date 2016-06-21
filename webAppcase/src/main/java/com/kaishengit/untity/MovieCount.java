package com.kaishengit.untity;

import java.util.List;

public class MovieCount<T> {
    /**
     * 总记录数
     */
    private Integer pagecounts;
    /**
     * 每页数量
     */
    private Integer pagesize;
    /**
     * 当前页数
     */
    private  Integer pageNo;
    /**
     * 总页数
     */
    private  Integer pagesizes;
    /**
     * movie 值
     */
    private List<T> items;
    /**
     * 起始记录数
     */
    private Integer start;

    public Integer getStart() {
        return start;
    }

    public Integer getPagecounts() {
        return pagecounts;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPagesizes() {
        return pagesizes;
    }

    public List<T> getItems() {
        return items;
    }

    public MovieCount(Integer pagecounts, Integer pagesize, Integer pageNo) {
        this.pagecounts = pagecounts;
        this.pagesize = pagesize;
        this.pageNo = pageNo;
        pagesizes=pagecounts/pagesize;
        if(pagecounts%pagesize!=0){
           pagesizes++;

        }
        if(pageNo>pagesizes){
            this.pageNo=pagesizes;
        }
        if(pageNo<=0){
            this.pageNo=1;
        }
        start=(this.pageNo-1)*pagesize;



    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
