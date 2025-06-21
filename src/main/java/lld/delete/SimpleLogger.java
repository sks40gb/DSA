package lld.delete;

import java.util.ArrayList;
import java.util.List;

public class SimpleLogger implements Logger {
    private List<Appender> appenders;
    private LogFormatter formatter;

    public SimpleLogger(LogFormatter formatter) {
        this.appenders = new ArrayList<>();
        this.formatter = formatter;
    }

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    @Override
    public void log(LogLevel level, String message) {
        String formattedMessage = formatter.format(level, message);
        for (Appender appender : appenders) {
            appender.append(formattedMessage);
        }
    }

    @Override
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    @Override
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    @Override
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    @Override
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
