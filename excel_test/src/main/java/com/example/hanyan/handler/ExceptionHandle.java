package com.example.hanyan.handler;


import com.example.hanyan.common.Result;
import com.example.hanyan.exception.ExcelException;
import com.example.hanyan.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vigo.xian
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof ExcelException) {
            //判断异常是否是我们定义的异常
            ExcelException excelException = (ExcelException) e;
            return ResultUtil.error(excelException.getCode(), excelException.getMessage());
        }else {
            log.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
