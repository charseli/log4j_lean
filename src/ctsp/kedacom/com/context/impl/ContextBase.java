package ctsp.kedacom.com.context.impl;

import ctsp.kedacom.com.context.Context;

public class ContextBase implements Context {

    private String name;

    private Long birthTime = System.currentTimeMillis();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getBirthTime() {
        return birthTime;
    }
}
