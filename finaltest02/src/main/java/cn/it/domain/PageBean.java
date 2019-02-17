package cn.it.domain;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.List;

public class PageBean<T> implements Serializable {
    /**
     * pageNum:当前页码
     * counts:总记录数
     * pages:总页数
     * pageSize:每页显示条数
     * pageStart:开始位置
     * List:存储的用户数据
     */
    private Integer pageNum;
    private Integer counts;
    private Integer pages;
    private Integer pageSize;
    private Integer pageStart;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
}
