package com.yu.demo.utils;

import com.yu.demo.domain.CustomerDomain;

import java.util.List;

/**
 * 查询分页数据的工具类
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-03-08 16:08
 */
public class PageList<T> {

    //分页的数据
    private List<CustomerDomain> customers;

    //每页显示的数据量
    private int pageSize = 6;

    //总记录数
    private long totalRecord;

    //当前页数
    private long currentPage;

    //总页数
    private int totalPage;

    private int startIndex;

    /*设置页码只能显示5页*/
    private int startPage;//起始页
    private int endPage;//末页

    //请求路径
    private String url;


    /**
     * 有参构造
     * 参数：当前页、总页数
     */
    public PageList(long currentPage, long totalRecord) {

        //将传递进来的currentPage进行初始化
        this.currentPage = currentPage;
        //计算出总页数
        totalPage = (int) (totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1);
        //总记录数
        this.totalRecord = totalRecord;

        //设置查询数据的开始值
        startIndex = (int) (currentPage - 1) * pageSize;

        //设置只能显示5页的页码
        if (currentPage <= 3) {
            this.startPage = 1;
            if(totalPage >5){
                this.endPage = 5;
            }else {
                this.endPage = totalPage;
            }
        } else {
            this.startPage = ((int) currentPage - 2);
            this.endPage = (int) currentPage + 2;
            if (startPage < 1) {
                this.startPage = 1;
                this.endPage = 5;
            }

            if (totalPage <= 5) {
                this.startPage = 1;
                this.endPage = totalPage;
            }

            if (endPage > totalPage) {
                this.startPage = this.totalPage - 4;
                this.endPage = this.totalPage;
            }
        }
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<CustomerDomain> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDomain> customers) {
        this.customers = customers;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
