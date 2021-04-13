package com.example.hanyan.hanee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hanyan.hanee.entity.TradeInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 交易信息 服务类
 * </p>
 *
 * @author vigo
 * @since 2021-04-06
 */
public interface ITradeInfoService extends IService<TradeInfo> {

    /**
     * 查询导出数据
     * @param page 分页参数
     * @return 列表分页
     */
    IPage<TradeInfo> selectPage(Page<?> page);

}
