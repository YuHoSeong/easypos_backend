package com.pcpos.easypos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyposApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyposApplication.class, args);

		Logger logger = LoggerFactory.getLogger(EasyposApplication.class);

		logger.debug("debug Logger");
		logger.info("info Logger");
		logger.error("error Logger");
		logger.warn("warn Logger");
		logger.trace("trace Logger");
	}

}
