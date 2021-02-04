package user.manager.logs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author imenb
 *
 */
@SpringBootApplication
public class LoggerApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(LoggerApplication.class);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(LoggerApplication.class, args);
		
		LOGGER.info("This is information");
		LOGGER.debug("This is debug");
		LOGGER.trace("this is a trace");
		LOGGER.error("This is error");
	}

}