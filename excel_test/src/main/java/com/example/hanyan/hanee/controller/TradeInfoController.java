package com.example.hanyan.hanee.controller;


import com.example.hanyan.hanee.service.impl.TradeInfoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * 交易信息 前端控制器
 * </p>
 *
 * @author vigo
 * @since 2021-04-06
 */
@Controller
@RequestMapping("/hanee/trade")
public class TradeInfoController {

    private TradeInfoServiceImpl tradeInfoService;

    @RequestMapping(value = "/eec", method = RequestMethod.GET)
    public void export(){
        tradeInfoService.list();
    }
}
