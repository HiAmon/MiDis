package com.amon.wfx.selfmedia.utils;

import java.util.List;

public class PageUtil {

    public static final int PAGE_SIZE = 5;   //每页显示记录数
    private int pageNum;    //当前页码（当前第几页
    private int pageCount;  //总页码（有多少页
    private String url;        //点击下一页的请求路径
    private List data;      //当前页的数据

    public PageUtil() {
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNum=" + pageNum +
                ", pageCount=" + pageCount +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }
}
