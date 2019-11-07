package ctsp.kedacom.com.aware;

import ctsp.kedacom.com.context.Context;

public interface ContextAware {

    void setContext(Context context);

    Context getContext();
}
