package com.example.hanyan.eec.export;

import lombok.Data;
import org.ttzero.excel.annotation.ExcelColumn;

import java.time.LocalDateTime;

/**
 * @author vigo.xian
 */

@Data
public class TradeExportDTO {
    /**
     * 主键
     */
    @ExcelColumn("主键")
    private Long id;

    /**
     * 交易订单号
     */
    @ExcelColumn("交易订单号")
    private String tradeNo;

    /**
     * 交易成功的预支付订单
     */
    @ExcelColumn("交易成功的预支付订单")
    private String prepTradeNo;

    /**
     * 商户号
     */
    @ExcelColumn("商户号")
    private String mchNo;

    /**
     * 商户订单号
     */
    @ExcelColumn("商户订单号")
    private String outTradeNo;

    /**
     * 第三发支付平台交易号
     */
    @ExcelColumn("第三发支付平台交易号")
    private String thirdTradeNo;

    /**
     * 免密协议号
     */
    @ExcelColumn("免密协议号")
    private String contractNo;

    /**
     * 微信用户的openid
     */
    @ExcelColumn("微信openid")
    private String openid;

    /**
     * 交易方式：1-微信，2-支付宝 3-银联 4-招商一网通
     */
    @ExcelColumn("交易方式")
    private Integer tradeWay;

    /**
     * 交易场景：1-PC网页，2-手机浏览器 3-微信浏览器 4-微信小程序 5-支付宝花呗
     */
    @ExcelColumn("交易场景")
    private Integer tradeScenes;

    /**
     * 预支付金额
     */
    @ExcelColumn("预支付金额")
    private Long prepayAmount;

    /**
     * 实际支付金额
     */
    @ExcelColumn("实际支付金额")
    private Long actualAmount;

    /**
     * 备注
     */
    @ExcelColumn("备注")
    private String remark;

    /**
     * 业务名称,第三方支付显示
     */
    @ExcelColumn("业务名称")
    private String businessName;

    /**
     * 交易完成时间
     */
    @ExcelColumn("交易完成时间")
    private LocalDateTime finishedTime;


    /**
     * 0->支付中 1->支付成功 2->取消 3->部分退款 4->已退款
     */
    @ExcelColumn("支付状态")
    private Integer status;

    /**
     * 创建者
     */
    @ExcelColumn("创建者")
    private String createdBy;

    /**
     * 创建时间
     */
    @ExcelColumn("创建时间")
    private LocalDateTime createdTime;

    /**
     * 更新者
     */
    @ExcelColumn("更新者")
    private String updatedBy;

    /**
     * 更新时间
     */
    @ExcelColumn("更新时间")
    private LocalDateTime updatedTime;
}
