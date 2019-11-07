package ctsp.kedacom.com.aware.impl;

import ctsp.kedacom.com.aware.ContextAware;
import ctsp.kedacom.com.context.Context;

public class ContextAwareBase implements ContextAware {

    private Context context;

    @Override
    public void setContext(Context context) {
        if (this.context==null){
            this.context = context;
        }else{
            throw new IllegalStateException("Context has been already set");
        }
    }

    @Override
    public Context getContext() {
        return this.context;
    }
}
