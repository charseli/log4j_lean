package ctsp.kedacom.com.binder;

import ctsp.kedacom.com.factory.ILoggerFactory;

public interface LoggerFactoryBinder {

    ILoggerFactory getLoggerFactory();

    String getLoggerFactoryClassStr();
}
