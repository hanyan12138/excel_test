package com.example.hanyan.exception;

import com.example.hanyan.common.ResultEnum;

/**
 * @author vigo.xian
 */
public class ExcelException extends RuntimeException{

    private Integer code;

    public ExcelException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
