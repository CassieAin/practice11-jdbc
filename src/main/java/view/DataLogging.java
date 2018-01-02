package view;

import org.apache.log4j.Logger;

public class DataLogging {

    static Logger logger = Logger.getLogger(DataLogging.class);

    public static void logData(String data){
        try {
            logger.info(data);
        } catch (IllegalArgumentException e) {
            logger.error("Negative argument", e);
        }
    }
}
