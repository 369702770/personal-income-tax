package com.xyl.personalincometax.constant;

import java.math.BigDecimal;

public class Constants {
    /**
     * 五险一金折减系数
     */
    public final static BigDecimal loss = new BigDecimal("0.78");
    /**
     * 税率
     */
    public final static Double poorTaxRate = 0.03D;
    /**
     * 速算扣除数
     */
    public final static Double poorQuickCalculDeduction = 0D;
}
