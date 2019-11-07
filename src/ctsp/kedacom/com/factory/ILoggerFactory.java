package ctsp.kedacom.com.factory;

import ctsp.kedacom.com.log.Logger;

public interface ILoggerFactory {
    Logger getLogger(String name);
}
