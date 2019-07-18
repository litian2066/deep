package com.dev.devinspringboot.pattern.structural.decorator.v2;

/**
 * 煎饼类
 */
public class BatterCake extends AbstractBatterCake {

    protected String getDesc() {
        return "煎饼";
    }

    /**
     * 8元
     * @return
     */
    protected int cost() {
        return 8;
    }
}
