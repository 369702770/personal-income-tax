package com.xyl.personalincometax.service;

import com.xyl.personalincometax.vo.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xyl.personalincometax.constant.Constants;

import java.math.BigDecimal;

/**
 * 个税计算业务逻辑层
 */
@Service
public class PoorIncomeTax implements IncomeTaxStrategyFactory {
    @Autowired
    private HomePayService homePayService;

    /**
     * 计算个税
     *
     * @param grossPay               税前收入
     * @param socialInsurancePremium 各项社会保险费
     * @param threshold              起征点
     * @return 税后收入
     */
    @Override
    public Money incomeTax(BigDecimal grossPay, BigDecimal socialInsurancePremium, BigDecimal threshold) {
        Money money = homePayService.homePay(grossPay,
                socialInsurancePremium,
                Constants.loss,
                threshold,
                Constants.poorTaxRate,
                Constants.poorQuickCalculDeduction);
        return money;
    }
}
