package com.xyl.personalincometax.contruller;

import com.xyl.personalincometax.response.Result;
import com.xyl.personalincometax.response.Results;
import com.xyl.personalincometax.service.IncomeTaxImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


/**
 * 个税计算
 */
@RestController
public class TaxContruller {
    @Autowired
    private IncomeTaxImpl poorIncomeTax;

    /**
     * 计算个税
     *
     * @param grossPay               税前收入
     * @param socialInsurancePremium 各项社会保险费
     * @param threshold              起征点
     * @return 税后收入
     */
    @RequestMapping(value = "/money", method = RequestMethod.GET)
    public Result getMoney(@RequestParam(value = "grossPay") BigDecimal grossPay,
                           @RequestParam(value = "socialInsurancePremium", required = false) BigDecimal
                                   socialInsurancePremium,
                           @RequestParam(value = "threshold", defaultValue = "5000") BigDecimal threshold) {
        return Results.success(poorIncomeTax.incomeTax(grossPay, socialInsurancePremium, threshold));
    }
}
