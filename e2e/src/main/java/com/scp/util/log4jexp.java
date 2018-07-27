package com.scp.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log4jexp {
	public static Logger logger = Logger.getLogger(log4jexp.class);
	public static void main(String[] args) {
logger.setLevel(Level.ALL);
PropertyConfigurator.configure("log4j.properties");
		for (int i=0;i<10;i++){
			logger.fatal("This is fatal msg");
			logger.error("This is error msg");
			//logger.log(MyOwnLevel.DISASTER, "my disaster message");
			logger.warn("This is warn msg");
			logger.info("This is info msg");
			logger.debug("This is debug msg");
			logger.trace("This is trace msg");
			//TimeUnit.SECONDS.sleep(20);
		}
	}
}
