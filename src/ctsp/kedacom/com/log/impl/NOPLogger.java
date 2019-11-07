package ctsp.kedacom.com.log.impl;

import ctsp.kedacom.com.log.Logger;

public class NOPLogger implements Logger {

    private NOPLogger(){}

    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    @Override
    public String getName() {
        return "NOP";
    }
}
