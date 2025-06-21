package lld.delete;

public class SimpleLogFormatter implements LogFormatter {
    @Override
    public String format(LogLevel level, String message) {
        return "[" + level.name() + "] " + message;
    }
}