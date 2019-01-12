package com.xyl.personalincometax.service;

import com.xyl.personalincometax.constant.Constants;
import com.xyl.personalincometax.vo.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 个税计算业务逻辑层
 */
@Service
public class IncomeTaxImpl implements IncomeTaxInterface {
    @Autowired
    private HomePayService homePayService;

    @Value("${tax.poorQuickCalculDeduction}")
    private String poorQuickCalculDeduction;

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
        //税率级别
        double taxRate;
        double quick = 0d;
        String[] deduction = poorQuickCalculDeduction.split(" ");
        if (grossPay.compareTo(new BigDecimal(5001)) == Constants.bigResult) {
            taxRate = 0d;
        } else if (grossPay.compareTo(new BigDecimal(8001)) == Constants.bigResult) {
            taxRate = 0.03d;
        } else if (grossPay.compareTo(new BigDecimal(17001)) == Constants.bigResult) {
            taxRate = 0.10d;
            quick = Double.valueOf(deduction[0]);
        } else if (grossPay.compareTo(new BigDecimal(30001)) == Constants.bigResult) {
            taxRate = 0.20d;
            quick = Double.valueOf(deduction[1]);
        } else if (grossPay.compareTo( new BigDecimal(40001)) == Constants.bigResult) {
            taxRate = 0.25d;
            quick = Double.valueOf(deduction[2]);
        } else if (grossPay.compareTo( new BigDecimal(60001)) == Constants.bigResult) {
            taxRate = 0.30d;
            quick = Double.valueOf(deduction[3]);
        } else if (grossPay.compareTo(new BigDecimal(850001)) == Constants.bigResult) {
            taxRate = 0.35d;
            quick = Double.valueOf(deduction[4]);
        } else {
            taxRate = 0.45d;
            quick = Double.valueOf(deduction[5]);
        }
        return homePayService.homePay(grossPay,
                socialInsurancePremium,
                Constants.loss,
                threshold,
                taxRate,
                quick);
    }
}
