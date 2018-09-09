package com.xyl.personalincometax.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 薪金
 */
@Setter
@Getter
@ToString
public class Money implements Serializable {
    /**
     * 税后工资
     */
    private BigDecimal homePay;
    /**
     * 个人所得税
     */
    private BigDecimal personalTax;
    /**
     * 应纳税所得额
     */
    private BigDecimal taxableIncome;
    /**
     * 适用税率
     */
    private Double taxRate;
    /**
     * 速算扣除数
     */
    private Double quickCalculDeduction;
}
