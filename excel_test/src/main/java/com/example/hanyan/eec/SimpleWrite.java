package com.example.hanyan.eec;

import com.example.hanyan.eec.export.TradeExportDTO;
import org.ttzero.excel.entity.ListSheet;
import org.ttzero.excel.entity.Workbook;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vigo.xian
 * @date 2021.4.1
 */
public class SimpleWrite {


    public void exportTradeInfo() throws IOException {
        List<TradeExportDTO> tradeExportDTOList = new ArrayList<>();

        new Workbook("交易信息", "vigo.xian")
                .addSheet(new ListSheet<>("交易明细", tradeExportDTOList))
                .writeTo(Paths.get("f:/excel"));

    }

}
