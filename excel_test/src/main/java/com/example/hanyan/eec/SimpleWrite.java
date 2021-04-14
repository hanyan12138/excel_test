package com.example.hanyan.eec;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hanyan.eec.export.TradeExportDTO;
import com.example.hanyan.hanee.entity.TradeInfo;
import com.example.hanyan.hanee.service.impl.TradeInfoServiceImpl;
import com.example.hanyan.util.CollectionUtil;
import com.example.hanyan.util.TradeInfoTransUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.ttzero.excel.entity.ListSheet;
import org.ttzero.excel.entity.Sheet;
import org.ttzero.excel.entity.Workbook;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vigo.xian
 * @date 2021.4.1
 */
@Slf4j
@Service
public class SimpleWrite {

    @Resource
    private TradeInfoServiceImpl tradeInfoService;

    @Resource
    private DataSource dataSource;

    public void exportTradeInfo(List<TradeInfo> tradeInfoList, HttpServletResponse response) throws IOException {
        List<TradeExportDTO> tradeExportDTOList = new ArrayList<>();
        tradeExportDTOList = TradeInfoTransUtil.transformTradeExportDTO(tradeInfoList);
        new Workbook("交易信息", "vigo.xian")
                .addSheet(new ListSheet<>("交易明细", tradeExportDTOList))
                .writeTo(response.getOutputStream());
//                .writeTo(Paths.get("F:excel"));
    }

    @Async
    public void exportTradeInfoLarge() throws IOException {
        log.info("调用开始时间：" + System.currentTimeMillis());
        Long beginTime = System.currentTimeMillis();

        new Workbook("Large EEC").addSheet(new ListSheet<TradeExportDTO>() {
            int i = 0;
            IPage<TradeInfo> tradeInfoIPage = new Page<>(1, 500);
            List<TradeExportDTO> tradeExportDTOList = new ArrayList<>();

            @Override
            public List<TradeExportDTO> more() {
                if (i++ >= 50) {
                    return null;
                }
                tradeInfoIPage.setPages(i);
                tradeInfoIPage = tradeInfoService.page(tradeInfoIPage);
                if (CollectionUtil.isEmpty(tradeInfoIPage.getRecords())) {
                    return null;
                }
                tradeExportDTOList = TradeInfoTransUtil.transformTradeExportDTO(tradeInfoIPage.getRecords());

                return tradeExportDTOList;
            }
        }).writeTo(Paths.get("F:excel"));

        System.out.printf("tradeInfoList");
        log.info("调用结束时间：" + System.currentTimeMillis());
        log.info("调用耗时：{}", System.currentTimeMillis() - beginTime);
    }

    @Async
    public void exportTradeInfoMysql() throws SQLException, IOException {
        Connection connection = dataSource.getConnection();
        //使用数据源处理
        new Workbook("交易测试", "hanyan")
                .setConnection(connection)
                .setAutoSize(true)
                .watch(System.out::println)
                .addSheet("交易测试"
                        , "select id,trade_no,updated_time from trade_info limit 10"
                        , new Sheet.Column("ID", int.class)
                        , new Sheet.Column("支付号", char.class)
                        , new Sheet.Column("支付时间", Timestamp.class)
                )
                .writeTo(Paths.get("f:\\excel"));

    }

}
