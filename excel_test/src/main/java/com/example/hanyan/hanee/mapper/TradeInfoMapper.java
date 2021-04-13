package com.example.hanyan.hanee.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hanyan.hanee.entity.TradeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 交易信息 Mapper 接口
 * </p>
 *
 * @author vigo
 * @since 2021-04-06
 */
public interface TradeInfoMapper extends BaseMapper<TradeInfo> {

    /**
     * 查询导出数据
     * @param page 分页参数
     * @return 列表分页
     */
    IPage<TradeInfo> selectPage(Page<?> page);
}
