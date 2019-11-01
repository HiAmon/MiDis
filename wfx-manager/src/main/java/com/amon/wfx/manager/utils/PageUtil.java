package com.amon.wfx.manager.utils;

import java.util.List;

public class PageUtil {

    public static final int PAGE_SIZE = 5;

    private int pageNum;  //当前页码
    private int pageCount;  //总页数
    private String url;   //跳转链接
    private List data;   //当前页所有数据

    public static int getPageSize() {
        return PAGE_SIZE;
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
