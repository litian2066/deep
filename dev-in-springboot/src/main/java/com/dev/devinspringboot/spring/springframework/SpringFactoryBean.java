package com.dev.devinspringboot.spring.springframework;

import org.springframework.beans.factory.FactoryBean;

public class SpringFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new SpringBean();
    }

    @Override
    public Class<?> getObjectType() {
        return SpringBean.class;
    }
}
