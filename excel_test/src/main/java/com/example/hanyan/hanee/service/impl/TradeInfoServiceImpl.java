package com.example.hanyan.hanee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hanyan.hanee.entity.TradeInfo;
import com.example.hanyan.hanee.mapper.TradeInfoMapper;
import com.example.hanyan.hanee.service.ITradeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 交易信息 服务实现类
 * </p>
 *
 * @author vigo
 * @since 2021-04-06
 */
@Service
public class TradeInfoServiceImpl extends ServiceImpl<TradeInfoMapper, TradeInfo> implements ITradeInfoService {

    @Resource
    private TradeInfoMapper tradeInfoMapper;

    @Override
    public IPage<TradeInfo> selectPage(Page<?> page) {
        return tradeInfoMapper.selectPage(page);
    }
}
