package com.example.hanyan.hanee.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hanyan.common.Result;
import com.example.hanyan.eec.SimpleWrite;
import com.example.hanyan.eec.export.TradeExportDTO;
import com.example.hanyan.hanee.entity.TradeInfo;
import com.example.hanyan.hanee.service.impl.TradeInfoServiceImpl;
import com.example.hanyan.util.CollectionUtil;
import com.example.hanyan.util.ResultUtil;
import com.example.hanyan.util.TradeInfoTransUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ttzero.excel.entity.ListSheet;
import org.ttzero.excel.entity.Workbook;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 交易信息 前端控制器
 * </p>
 *
 * @author vigo
 * @since 2021-04-06
 */
@Slf4j
@RestController
@RequestMapping("/eec")
public class TradeInfoController {

    @Resource
    private TradeInfoServiceImpl tradeInfoService;

    @Resource
    private SimpleWrite simpleWrite;

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public Result<List<TradeInfo>> export(HttpServletResponse response) throws IOException {
        IPage<TradeInfo> tradeInfoIPage = new Page<>(2, 100);
        tradeInfoIPage = tradeInfoService.page(tradeInfoIPage);
        List<TradeInfo> tradeInfoList = tradeInfoIPage.getRecords();
        System.out.printf("tradeInfoList");
        simpleWrite.exportTradeInfo(tradeInfoList, response);
        return ResultUtil.success(tradeInfoList);
    }

    @Async
    @RequestMapping(value = "/export2", method = RequestMethod.GET)
    public Result<List<TradeInfo>> export2(HttpServletResponse response) throws IOException {
        simpleWrite.exportTradeInfoLarge();
        return ResultUtil.success(null);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<String> detail() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return ResultUtil.success(userDetails);
    }
}
