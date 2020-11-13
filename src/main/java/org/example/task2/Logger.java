package org.example.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    protected int counter = 1;
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        System.out.println("[" + getTime() + " " + counter++ + "] " + message);
    }

    private String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
