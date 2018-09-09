package com.xyl.personalincometax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan("com.xyl.*")
public class PersonalIncomeTaxApplication {
	private static Logger LOGGER = LogManager.getLogger(PersonalIncomeTaxApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(PersonalIncomeTaxApplication.class, args);
		LOGGER.info("个税计算器服务启动成功");
	}
}
