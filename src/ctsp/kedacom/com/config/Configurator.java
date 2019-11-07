package ctsp.kedacom.com.config;

import ctsp.kedacom.com.aware.ContextAware;
import ctsp.kedacom.com.context.LoggerContext;

public interface Configurator extends ContextAware {

    void configure(LoggerContext loggerContext);

}
