package ctsp.kedacom.com.binder.impl;

import ctsp.kedacom.com.binder.ContextSelectorStaticBinder;
import ctsp.kedacom.com.binder.LoggerFactoryBinder;
import ctsp.kedacom.com.context.LoggerContext;
import ctsp.kedacom.com.factory.ILoggerFactory;
import ctsp.kedacom.com.factory.impl.NOPLoggerFactory;
import ctsp.kedacom.com.initializer.ContextInitializer;

public class LoggerFactoryStaticBinder implements LoggerFactoryBinder {
    public static final String DEFAULT_CONTEXT_NAME = "default";

    /**
     * The unique instance of this class.
     */
    private static LoggerFactoryStaticBinder SINGLETON = new LoggerFactoryStaticBinder();

    private static LoggerContext defaultContext = new LoggerContext();

    private static ContextSelectorStaticBinder contextSelectorBinder = ContextSelectorStaticBinder.getSingleton();

    private boolean initialized = false;

    public static LoggerFactoryStaticBinder getSingleton() {
        return SINGLETON;
    }

    private LoggerFactoryStaticBinder(){
        defaultContext.setName(DEFAULT_CONTEXT_NAME);
    }

    static {
        SINGLETON.init();
    }

    private void init() {
        new ContextInitializer(defaultContext).autoConfig();
        try {
            contextSelectorBinder.init(new Object(), defaultContext);
            initialized = true;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public ILoggerFactory getLoggerFactory() {
        if (!initialized){
            return defaultContext;
        }
        if (contextSelectorBinder.getContextSelector()==null){
            throw new IllegalStateException("contextSelector cannot be null when initialized");
        }
        return contextSelectorBinder.getContextSelector().getLoggerContext();
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return contextSelectorBinder.getClass().getName();
    }
}
