package lld.delete;

public class LoggerTest {
    public static void main(String[] args) {
        LogFormatter formatter = new SimpleLogFormatter();
        Logger logger = new SimpleLogger(formatter);

        // Adding a file appender
        logger.addAppender(new FileAppender("application.log"));

        // Logging various messages
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }
}
