package com.kaishengit.untity;

import java.util.List;

public class Page<T> {
    /**
     * 总记录数
     */
    private  Integer totalsize;
    /**
     *总页数
     */
    private Integer totalPages;
    /**
     * 当前页码
     *
     */
    private Integer pageNo;
    /**
     * 每页显示多少
     */
    private Integer pagesize;
    /**
     *获取当前页数起始行数
     */
    private Integer start;
    private List<T> items;

    /**
     *
     * @param totalsize 总记录数
     * @param pageNo 当前页数
     * @param pagesize 每页显示多少
     */


    public Page( Integer pageNo, Integer pagesize,Integer totalsize) {
        this.totalsize = totalsize;
        this.pageNo = pageNo;
        this.pagesize = pagesize;
        totalPages=totalsize/pagesize;
        if(totalsize % pagesize!=0){
            totalPages++;

        }
        if(pageNo>totalPages){
            this.pageNo=totalPages;

        }
        if(pageNo<=0){
            this.pageNo=1;

        }
        start=(this.pageNo-1)*pagesize;














    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public Integer getStart() {
        return start;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
