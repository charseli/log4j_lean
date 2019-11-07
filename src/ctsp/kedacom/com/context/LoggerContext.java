package ctsp.kedacom.com.context;

import ctsp.kedacom.com.log.Logger;
import ctsp.kedacom.com.context.impl.ContextBase;
import ctsp.kedacom.com.factory.ILoggerFactory;

public class LoggerContext extends ContextBase implements ILoggerFactory {

    @Override
    public Logger getLogger(String name) {
        return null;
    }
}
