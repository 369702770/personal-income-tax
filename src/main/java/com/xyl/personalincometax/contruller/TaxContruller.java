package com.xyl.personalincometax.contruller;

import com.xyl.personalincometax.response.Result;
import com.xyl.personalincometax.response.Results;
import com.xyl.personalincometax.service.PoorIncomeTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 个税计算
 */
@RestController
public class TaxContruller {
    @Autowired
    private PoorIncomeTax poorIncomeTax;
    @RequestMapping(value = "/money",method = RequestMethod.POST)
    public Result getMoney(){
        return Results.success(poorIncomeTax.incomeTax(null,null,null));
    }
}
