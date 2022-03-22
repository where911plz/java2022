package kr.mjc.jacob.basics.concurrency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLogger {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(HelloLogger.class);
		log.debug("Hello {}", "SLF4J");

	}
}
