package com.example.hanyan.util;

import com.example.hanyan.eec.export.TradeExportDTO;
import com.example.hanyan.hanee.entity.TradeInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author vigo.xian
 */
public class TradeInfoTransUtil {

    private TradeInfoTransUtil(){
    }

    public static TradeExportDTO transformTradeExportDTO(TradeInfo tradeInfo){
        if (null == tradeInfo) {
            return null;
        }
        TradeExportDTO tradeExportDTO = new TradeExportDTO();
        BeanUtils.copyProperties(tradeInfo, tradeExportDTO);
        return tradeExportDTO;
    }

    public static List<TradeExportDTO> transformTradeExportDTO(List<TradeInfo> tradeInfoList){
        if (CollectionUtil.isEmpty(tradeInfoList)) {
            return new ArrayList<>(0);
        }
        return  tradeInfoList.stream().map(TradeInfoTransUtil::transformTradeExportDTO).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
