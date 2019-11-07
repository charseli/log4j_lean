package ctsp.kedacom.com;

import ctsp.kedacom.com.aware.impl.ContextAwareBase;
import ctsp.kedacom.com.config.Configurator;
import ctsp.kedacom.com.context.Context;
import ctsp.kedacom.com.context.LoggerContext;

public class BasicConfigurator extends ContextAwareBase implements Configurator {
    @Override
    public void configure(LoggerContext loggerContext) {

    }

    @Override
    public void setContext(Context context) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
