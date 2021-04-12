package com.example.hanyan.hanee.entity;

import java.time.LocalDateTime;
import com.example.hanyan.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易信息
 * </p>
 *
 * @author vigo
 * @since 2021-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TradeInfo extends BaseEntity {


    /**
     * 交易订单号
     */
    private String tradeNo;

    /**
     * 交易成功的预支付订单
     */
    private String prepTradeNo;

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 第三发支付平台交易号
     */
    private String thirdTradeNo;

    /**
     * 免密协议号
     */
    private String contractNo;

    /**
     * 微信用户的openid
     */
    private String openid;

    /**
     * 交易方式：1-微信，2-支付宝 3-银联 4-招商一网通
     */
    private Integer tradeWay;

    /**
     * 交易场景：1-PC网页，2-手机浏览器 3-微信浏览器 4-微信小程序 5-支付宝花呗
     */
    private Integer tradeScenes;

    /**
     * 预支付金额
     */
    private Long prepayAmount;

    /**
     * 实际支付金额
     */
    private Long actualAmount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 业务名称,第三方支付显示
     */
    private String businessName;

    /**
     * 交易完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 通知topic
     */
    private String notifyTopic;

    /**
     * 通知tag
     */
    private String notifyTag;

    /**
     * 通知编码格式，0：原始byte[]，1: Base64的byte[]
     */
    private Integer notifyEncoding;

    /**
     * 通知时间
     */
    private LocalDateTime notifyTime;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 版本号，用于乐观锁
     */
    private Integer version;

    /**
     * 0->支付中 1->支付成功 2->取消 3->部分退款 4->已退款
     */
    private Boolean status;

    /**
     * 创建者
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新者
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
