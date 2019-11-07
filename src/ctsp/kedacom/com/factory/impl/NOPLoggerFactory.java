package ctsp.kedacom.com.factory.impl;

import ctsp.kedacom.com.log.Logger;
import ctsp.kedacom.com.factory.ILoggerFactory;
import ctsp.kedacom.com.log.impl.NOPLogger;

public class NOPLoggerFactory implements ILoggerFactory {
    @Override
    public Logger getLogger(String name) {
        return NOPLogger.NOP_LOGGER;
    }
}
