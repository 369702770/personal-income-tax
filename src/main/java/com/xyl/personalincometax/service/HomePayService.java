package com.xyl.personalincometax.service;

import com.xyl.personalincometax.util.NumberUtil;
import com.xyl.personalincometax.vo.Money;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HomePayService {
    public Money homePay(BigDecimal grossPay, BigDecimal socialInsurancePremium, BigDecimal loss, BigDecimal
            threshold, Double taxRate, Double quickCalculDeduction) {
        Money money = new Money();
        //扣除五险一金
        BigDecimal persionalTax;
        if (socialInsurancePremium != null) {
            persionalTax = NumberUtil.safeSubtract(grossPay, socialInsurancePremium);
        } else {
            persionalTax = NumberUtil.safeMultiply(grossPay, loss);
        }
        //应税工资
        BigDecimal taxableIncome = persionalTax;
        //减掉起征点
        persionalTax = NumberUtil.safeSubtract(persionalTax, threshold);
        //乘以使用税率
        persionalTax = NumberUtil.safeMultiply(persionalTax, new BigDecimal(taxRate));
        //减去速算扣除数
        persionalTax = NumberUtil.safeSubtract(persionalTax, new BigDecimal(quickCalculDeduction));
        //税后收入=应税工资-个人所得税
        BigDecimal homePay = NumberUtil.safeSubtract(taxableIncome, persionalTax);
        //税后收入
        money.setHomePay(homePay);
        //个人所得税
        money.setPersonalTax(persionalTax);
        //应税工资
        money.setTaxableIncome(taxableIncome);
        //适用税率
        money.setTaxRate(taxRate);
        //速算扣除数
        money.setQuickCalculDeduction(quickCalculDeduction);
        return money;
    }
}
