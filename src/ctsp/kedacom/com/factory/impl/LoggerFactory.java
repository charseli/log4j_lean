package ctsp.kedacom.com.factory.impl;

import ctsp.kedacom.com.binder.impl.LoggerFactoryStaticBinder;
import ctsp.kedacom.com.factory.ILoggerFactory;
import ctsp.kedacom.com.log.Logger;

public class LoggerFactory {
    /**
     * 初始化对象状态
     */
    public static final int NOT_INIT = 0;
    public static final int ON_GOING_INIT = 1;
    public static final int FAIL_INIT = 2;
    public static final int SUCC_INIT = 3;
    public static final int NOP_FALLBACK_INIT = 4;
    static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER.";
    private static final NOPLoggerFactory NOP_FALLBACK_FACTORY = new NOPLoggerFactory();
    public volatile static int INIT_STATE = NOT_INIT;

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    /**
     * @param fqcn full quality class name.
     * @return .
     */
    public static Logger getLogger(String fqcn) {
        return getILoggerFactory().getLogger(fqcn);
    }

    public static ILoggerFactory getILoggerFactory() {
        if (INIT_STATE == NOT_INIT) {
            synchronized (LoggerFactory.class) {
                if (INIT_STATE == NOT_INIT) {
                    INIT_STATE = ON_GOING_INIT;
                    doInitialization();
                }
            }
        }
        switch (INIT_STATE) {
            case SUCC_INIT:
                return LoggerFactoryStaticBinder.getSingleton().getLoggerFactory();
            case FAIL_INIT:
                throw new IllegalStateException(UNSUCCESSFUL_INIT_MSG);
            case NOP_FALLBACK_INIT:
                return NOP_FALLBACK_FACTORY;
            default:
                throw new IllegalStateException("Unreachable code");
        }

    }

    private static final void doInitialization() {
        bind();
    }

    private static final void bind() {
        LoggerFactoryStaticBinder.getSingleton();
    }

}
