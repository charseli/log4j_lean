package ctsp.kedacom.com.selector;

import ctsp.kedacom.com.context.LoggerContext;

import java.util.List;

public interface ContextSelector {

    LoggerContext getLoggerContext();

    LoggerContext getLoggerContext(String name);

    LoggerContext getDefaultLoggerContext();

    LoggerContext detachLoggerContext(String loggerContextName);

    List<String> getContextNames();
}
