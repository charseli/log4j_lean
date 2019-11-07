package ctsp.kedacom.com.selector.impl;

import ctsp.kedacom.com.aware.impl.ContextAwareBase;
import ctsp.kedacom.com.context.LoggerContext;
import ctsp.kedacom.com.selector.ContextSelector;

import java.util.Arrays;
import java.util.List;

public class DefaultContextSelector extends ContextAwareBase implements ContextSelector {

    private LoggerContext defaultLoggerContext;

    public DefaultContextSelector(LoggerContext defaultLoggerContext) {
        this.defaultLoggerContext = defaultLoggerContext;
    }

    @Override
    public LoggerContext getLoggerContext() {
        return getDefaultLoggerContext();
    }

    @Override
    public LoggerContext getLoggerContext(String name) {
        return defaultLoggerContext.getName().equals(name) ? defaultLoggerContext : null;
    }

    @Override
    public LoggerContext getDefaultLoggerContext() {
        return defaultLoggerContext;
    }

    @Override
    public LoggerContext detachLoggerContext(String loggerContextName) {
        return defaultLoggerContext;
    }

    @Override
    public List<String> getContextNames() {
        return Arrays.asList(defaultLoggerContext.getName());
    }
}
