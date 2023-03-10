package com.tactical.privacy.stats;

public class Logger {

    public static Logger getLogger(Class<?> clazz){
        return new Logger();
    }

    public void info(String msg) {
        System.out.println(msg);
    }

    public void warn(String msg) {
        System.out.println(msg);
    }

    public void error(String msg, Exception ex) {
        System.out.println(msg);
        System.out.println(ex.getMessage());
    }
}