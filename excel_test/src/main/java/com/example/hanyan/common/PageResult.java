package com.example.hanyan.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询返回结果
 * @author vigo.xian
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -4184817785706628377L;
    private List<T> data;
    private Paginator paginator;

    public PageResult(List<T> data, Paginator paginator) {
        this.data = data;
        this.paginator = paginator;
        if (this.data == null || this.data.size() == 0) {
            this.data = new ArrayList(0);
        }

    }

    public List<T> getData() {
        return this.data;
    }

    public Paginator getPaginator() {
        return this.paginator;
    }
}
