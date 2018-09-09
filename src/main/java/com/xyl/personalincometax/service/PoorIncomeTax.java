package com.xyl.personalincometax.service;

import com.xyl.personalincometax.util.NumberUtil;
import com.xyl.personalincometax.vo.Money;
import org.springframework.stereotype.Service;
import com.xyl.personalincometax.constant.Constants;

import java.math.BigDecimal;

/**
 * 个税计算业务逻辑层
 */
@Service
public class PoorIncomeTax implements IncomeTaxStrategyFactory {
    /**
     * 计算个税
     * @param grossPay 税前收入
     * @param socialInsurancePremium 各项社会保险费
     * @param threshold 起征点
     * @return 税后收入
     */
    @Override
    public Money incomeTax(BigDecimal grossPay,BigDecimal socialInsurancePremium,BigDecimal threshold){
        Money money=new Money();
        //先扣除五险一金
        BigDecimal homePay=NumberUtil.safeMultiply(grossPay,Constants.loss);


        return money;
    }
}
