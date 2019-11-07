package ctsp.kedacom.com.binder;

import ctsp.kedacom.com.context.LoggerContext;
import ctsp.kedacom.com.selector.ContextSelector;
import ctsp.kedacom.com.selector.impl.DefaultContextSelector;

public class ContextSelectorStaticBinder {

    public static final String LOGBACK_CONTEXT_SELECTOR = "logback.ContextSelector";

    static ContextSelectorStaticBinder singleton = new ContextSelectorStaticBinder();

    ContextSelector contextSelector;

    Object key;

    public static ContextSelectorStaticBinder getSingleton() {
        return singleton;
    }

    public  void init(Object key, LoggerContext defaultLoggerContext) throws Exception {
        if (this.key == null) {
            this.key = key;
        } else if (this.key != key) {
            throw new IllegalAccessException("Only certain classes can access this method.");
        }
        String contextSelectorStr = System.getProperty(LOGBACK_CONTEXT_SELECTOR);
        if (contextSelectorStr==null){
            contextSelector = new DefaultContextSelector(defaultLoggerContext);
        }
    }

    public ContextSelector getContextSelector() {
        return contextSelector;
    }

}
