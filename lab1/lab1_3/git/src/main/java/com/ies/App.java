package com.ies;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * Hello world!
 *
 */
public class App 
{

    private static final Logger logger = LogManager.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
    }
}
