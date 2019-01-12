package com.xyl.personalincometax.service;

import com.xyl.personalincometax.vo.Money;

import java.math.BigDecimal;

/**
 * 计算个税策略工厂
 */
public interface IncomeTaxInterface {
    /**
     * 计算个税
     * @param grossPay 税前收入
     * @param socialInsurancePremium 各项社会保险费
     * @param threshold 起征点
     * @return 税后收入
     */
    Money incomeTax(BigDecimal grossPay, BigDecimal socialInsurancePremium, BigDecimal threshold);

}
