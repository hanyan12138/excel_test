package com.example.hanyan.common;


import lombok.Data;

import java.io.Serializable;

/**
 * @author vigo.xian
 */
@Data
public class Paginator implements Serializable {
    private static final long serialVersionUID = 7189578563832338583L;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalRecord;
    private Integer totalPage;
    private String orderSegment;

    public Paginator() {
        this.currentPage = 1;
        this.pageSize = 2147483647;
    }

    public Paginator(int currentPage, int pageSize) {
        this(currentPage, pageSize, (String)null);
    }

    public Paginator(int currentPage, int pageSize, String orderSegment) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.orderSegment = orderSegment;
    }

    public void nextPage() {
        if (null == this.currentPage) {
            this.currentPage = 1;
        } else {
            Integer var1 = this.currentPage;
            Integer var2 = this.currentPage = this.currentPage + 1;
        }

    }

    public boolean hasNextPage() {
        if (null != this.currentPage && null != this.totalPage) {
            return this.currentPage < this.totalPage;
        } else {
            return false;
        }
    }

    public int getFrom() {
        return null != this.currentPage && this.currentPage > 0 ? (this.currentPage - 1) * this.pageSize : 0;
    }

    public Paginator getPaginator() {
        return this;
    }


}
