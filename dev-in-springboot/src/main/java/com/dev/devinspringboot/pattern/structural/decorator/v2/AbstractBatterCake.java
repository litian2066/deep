package com.dev.devinspringboot.pattern.structural.decorator.v2;

/**
 * 创建抽象煎饼类
 */
public abstract class AbstractBatterCake {

    protected abstract String getDesc();

    /**
     * 8元
     * @return
     */
    protected abstract int cost();
}
